#!/usr/bin/env python3
"""Normalize whitespace in UTF-8 files recorded by OpenAPI Generator."""

from __future__ import annotations

from pathlib import Path, PurePosixPath

ROOT = Path(__file__).resolve().parent.parent
MANIFEST = ROOT / ".openapi-generator" / "FILES"


def main() -> None:
    for raw_path in MANIFEST.read_text(encoding="utf-8").splitlines():
        relative = PurePosixPath(raw_path)
        if relative.is_absolute() or ".." in relative.parts:
            raise ValueError(f"unsafe generated path: {raw_path}")
        path = ROOT.joinpath(*relative.parts)
        if not path.is_file() or path.is_symlink():
            continue
        try:
            original = path.read_text(encoding="utf-8")
        except UnicodeDecodeError:
            continue
        lines = original.splitlines()
        while lines and not lines[-1].strip():
            lines.pop()
        normalized = "\n".join(line.rstrip(" \t") for line in lines)
        if normalized:
            normalized += "\n"
        if normalized != original:
            path.write_text(normalized, encoding="utf-8")


if __name__ == "__main__":
    main()
