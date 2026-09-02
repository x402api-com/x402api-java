#!/usr/bin/env python3
"""Bind the handwritten runtime-version assertion to a generated SDK version."""

from __future__ import annotations

import argparse
import re
from pathlib import Path

SEMVER = re.compile(r"^(0|[1-9][0-9]*)\.(0|[1-9][0-9]*)\.(0|[1-9][0-9]*)$")
ASSERTION = re.compile(
    r'assertEquals\("[^"]+", Configuration\.VERSION\);'
)


def update_test(path: Path, version: str) -> None:
    if SEMVER.fullmatch(version) is None:
        raise ValueError("version must be stable SemVer")
    source = path.read_text(encoding="utf-8")
    updated, count = ASSERTION.subn(
        f'assertEquals("{version}", Configuration.VERSION);', source
    )
    if count != 1:
        raise ValueError("runtime version test must contain exactly one version assertion")
    path.write_text(updated, encoding="utf-8")


def main() -> None:
    parser = argparse.ArgumentParser()
    parser.add_argument("--version", required=True)
    parser.add_argument(
        "--test-path",
        type=Path,
        default=Path("src/test/java/com/x402api/client/core/ConfigurationVersionTest.java"),
    )
    arguments = parser.parse_args()
    update_test(arguments.test_path, arguments.version)


if __name__ == "__main__":
    main()
