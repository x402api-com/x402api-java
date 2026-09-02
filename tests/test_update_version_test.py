from __future__ import annotations

import importlib.util
import tempfile
import unittest
from pathlib import Path

SCRIPT = Path(__file__).parents[1] / "scripts" / "update-version-test.py"
SPEC = importlib.util.spec_from_file_location("update_version_test", SCRIPT)
assert SPEC and SPEC.loader
MODULE = importlib.util.module_from_spec(SPEC)
SPEC.loader.exec_module(MODULE)


class UpdateVersionTestTests(unittest.TestCase):
    def test_updates_the_single_runtime_version_assertion(self) -> None:
        with tempfile.TemporaryDirectory() as temporary:
            path = Path(temporary) / "ConfigurationVersionTest.java"
            path.write_text(
                'assertEquals("1.1.0", Configuration.VERSION);\n', encoding="utf-8"
            )
            MODULE.update_test(path, "1.2.0")
            self.assertEqual(
                path.read_text(encoding="utf-8"),
                'assertEquals("1.2.0", Configuration.VERSION);\n',
            )

    def test_rejects_a_missing_or_ambiguous_assertion(self) -> None:
        with tempfile.TemporaryDirectory() as temporary:
            path = Path(temporary) / "ConfigurationVersionTest.java"
            path.write_text("class ConfigurationVersionTest {}\n", encoding="utf-8")
            with self.assertRaisesRegex(ValueError, "exactly one"):
                MODULE.update_test(path, "1.2.0")

    def test_rejects_a_non_release_version(self) -> None:
        with tempfile.TemporaryDirectory() as temporary:
            path = Path(temporary) / "ConfigurationVersionTest.java"
            path.write_text(
                'assertEquals("1.1.0", Configuration.VERSION);\n', encoding="utf-8"
            )
            with self.assertRaisesRegex(ValueError, "stable SemVer"):
                MODULE.update_test(path, "1.2.0-rc.1")


if __name__ == "__main__":
    unittest.main()
