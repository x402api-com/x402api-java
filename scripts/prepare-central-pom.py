#!/usr/bin/env python3
"""Apply the stable Maven Central publication metadata after generation."""

from pathlib import Path

POM = Path(__file__).resolve().parent.parent / "pom.xml"
PLUGIN = """            <plugin>
                <groupId>org.sonatype.central</groupId>
                <artifactId>central-publishing-maven-plugin</artifactId>
                <version>0.11.0</version>
                <extensions>true</extensions>
                <configuration>
                    <publishingServerId>central</publishingServerId>
                    <autoPublish>true</autoPublish>
                    <waitUntil>published</waitUntil>
                    <skipPublishing>${central.skipPublishing}</skipPublishing>
                </configuration>
            </plugin>
"""


def main() -> None:
    source = POM.read_text()
    source = source.replace(
        "<url>https://github.com/openapitools/openapi-generator</url>",
        "<url>https://github.com/x402api-com/x402api-java</url>",
    ).replace(
        "<email>team@openapitools.org</email>",
        "<email>support@x402api.com</email>",
    )
    marker = "    <build>\n        <plugins>\n"
    if "<artifactId>central-publishing-maven-plugin</artifactId>" not in source:
        if source.count(marker) != 1:
            raise ValueError("generated POM has an unexpected build/plugins structure")
        source = source.replace(marker, marker + PLUGIN, 1)
    property_marker = "    <properties>\n"
    if "<central.skipPublishing>" not in source:
        if source.count(property_marker) != 1:
            raise ValueError("generated POM has an unexpected properties structure")
        source = source.replace(
            property_marker,
            property_marker
            + "        <central.skipPublishing>false</central.skipPublishing>\n",
            1,
        )
    POM.write_text(source)


if __name__ == "__main__":
    main()
