#!/usr/bin/env python3
"""Write a checked SDK source-provenance manifest."""

from __future__ import annotations

import argparse
import hashlib
import json
import re
from pathlib import Path

SEMVER = re.compile(r"^(0|[1-9][0-9]*)\.(0|[1-9][0-9]*)\.(0|[1-9][0-9]*)$")
SOURCE_REVISION = re.compile(r"^[0-9a-f]{40}$")
CONTRACT_DIGEST = re.compile(r"^sha256:[0-9a-f]{64}$")


def digest(document: object) -> str:
    canonical = json.dumps(document, sort_keys=True, separators=(",", ":"), ensure_ascii=True).encode()
    return f"sha256:{hashlib.sha256(canonical).hexdigest()}"


def build_manifest(public_openapi: Path, sdk_openapi: Path, version: str, source_revision: str, contract_digest: str) -> dict[str, str]:
    if SEMVER.fullmatch(version) is None:
        raise ValueError("version must be stable SemVer")
    if SOURCE_REVISION.fullmatch(source_revision) is None:
        raise ValueError("source revision must be an exact lowercase Git SHA")
    if CONTRACT_DIGEST.fullmatch(contract_digest) is None:
        raise ValueError("contract digest must be sha256-prefixed lowercase hex")
    public = json.loads(public_openapi.read_text())
    sdk = json.loads(sdk_openapi.read_text())
    if public.get("info", {}).get("version") != version or sdk.get("info", {}).get("version") != version:
        raise ValueError("contract version does not match release version")
    if digest(public) != contract_digest:
        raise ValueError("public contract digest does not match release input")
    return {"record_type": "x402api-sdk-source", "version": version, "source_revision": source_revision, "openapi_sha256": contract_digest, "sdk_openapi_sha256": digest(sdk)}


def main() -> None:
    parser = argparse.ArgumentParser()
    parser.add_argument("--public-openapi", type=Path, required=True)
    parser.add_argument("--sdk-openapi", type=Path, required=True)
    parser.add_argument("--version", required=True)
    parser.add_argument("--source-revision", required=True)
    parser.add_argument("--contract-digest", required=True)
    parser.add_argument("--output", type=Path, default=Path(".x402api/release.json"))
    arguments = parser.parse_args()
    manifest = build_manifest(arguments.public_openapi, arguments.sdk_openapi, arguments.version, arguments.source_revision, arguments.contract_digest)
    arguments.output.parent.mkdir(parents=True, exist_ok=True)
    arguments.output.write_text(json.dumps(manifest, indent=2) + "\n")


if __name__ == "__main__":
    main()
