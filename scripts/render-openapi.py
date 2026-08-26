#!/usr/bin/env python3
"""Render the deployed public contract into a safe server-SDK contract."""

from __future__ import annotations

import argparse
import copy
import json
import re
from pathlib import Path
from typing import Any

HTTP_METHODS = frozenset({"delete", "get", "head", "options", "patch", "post", "put"})
PUBLIC_OPERATIONS = frozenset(
    {
        ("/v1/facilitator/supported", "get"),
        ("/v1/payment-receipt-verification-keys", "get"),
    }
)
SEMVER = re.compile(r"^(0|[1-9][0-9]*)\.(0|[1-9][0-9]*)\.(0|[1-9][0-9]*)$")


def _normalize_schemas(schemas: dict[str, Any]) -> dict[str, Any]:
    """Make common wire schemas portable across the official generators."""

    normalized = copy.deepcopy(schemas)
    null_schema_names = {
        name
        for name, schema in normalized.items()
        if isinstance(schema, dict) and schema.get("enum") == [None]
    }
    null_references = {
        f"#/components/schemas/{name}" for name in null_schema_names
    }

    def normalize(value: Any) -> None:
        if isinstance(value, dict):
            one_of = value.get("oneOf")
            if isinstance(one_of, list):
                retained = [
                    branch
                    for branch in one_of
                    if not (
                        isinstance(branch, dict)
                        and branch.get("$ref") in null_references
                    )
                ]
                if len(retained) != len(one_of):
                    if not retained:
                        raise ValueError("null-only enum cannot be the sole oneOf branch")
                    value["nullable"] = True
                    if len(retained) == 1 and set(retained[0]) == {"$ref"}:
                        value.pop("oneOf")
                        value["allOf"] = retained
                    else:
                        value["oneOf"] = retained
            if value.get("type") == "string" and value.get("format") == "decimal":
                value.pop("format")
            for child in value.values():
                normalize(child)
        elif isinstance(value, list):
            for child in value:
                normalize(child)

    for name, schema in normalized.items():
        if name not in null_schema_names:
            normalize(schema)
    for name in null_schema_names:
        del normalized[name]
    return normalized


def _load(path: Path) -> dict[str, Any]:
    document = json.loads(path.read_text())
    if not isinstance(document, dict):
        raise ValueError("OpenAPI document must be a JSON object")
    if not str(document.get("openapi", "")).startswith("3."):
        raise ValueError("OpenAPI 3.x is required")
    version = document.get("info", {}).get("version")
    if not isinstance(version, str) or not SEMVER.fullmatch(version):
        raise ValueError("info.version must be stable SemVer")
    return document


def render(document: dict[str, Any]) -> dict[str, Any]:
    components = document.get("components")
    if not isinstance(components, dict):
        raise ValueError("components object is required")
    schemes = components.get("securitySchemes")
    if not isinstance(schemes, dict) or "tenantApiKey" not in schemes:
        raise ValueError("tenantApiKey security scheme is required")
    schemes.pop("humanIngressHmac", None)
    schemas = components.get("schemas")
    if not isinstance(schemas, dict):
        raise ValueError("components.schemas object is required")
    components["schemas"] = _normalize_schemas(schemas)

    tenant_security = [{"tenantApiKey": []}]
    document["security"] = tenant_security
    operation_ids: set[str] = set()
    operation_count = 0
    paths = document.get("paths")
    if not isinstance(paths, dict):
        raise ValueError("paths object is required")
    for path, path_item in list(paths.items()):
        if not isinstance(path_item, dict):
            continue
        for method, operation in list(path_item.items()):
            if method not in HTTP_METHODS or not isinstance(operation, dict):
                continue
            if operation.get("x-authentication-boundary") == (
                "human-tenant-owner-recent-step-up"
            ):
                del path_item[method]
                continue
            operation_count += 1
            operation_id = operation.get("operationId")
            if not isinstance(operation_id, str) or not operation_id:
                raise ValueError(f"{method.upper()} {path} is missing operationId")
            if operation_id in operation_ids:
                raise ValueError(f"duplicate operationId: {operation_id}")
            operation_ids.add(operation_id)
            operation["security"] = [] if (path, method) in PUBLIC_OPERATIONS else tenant_security
        if not any(method in HTTP_METHODS for method in path_item):
            del paths[path]

    if operation_count == 0:
        raise ValueError("no API operations were found")
    return document


def main() -> None:
    parser = argparse.ArgumentParser()
    parser.add_argument("--input", type=Path, required=True)
    parser.add_argument("--output", type=Path, required=True)
    args = parser.parse_args()
    document = render(_load(args.input))
    args.output.parent.mkdir(parents=True, exist_ok=True)
    args.output.write_text(json.dumps(document, indent=2) + "\n")


if __name__ == "__main__":
    main()
