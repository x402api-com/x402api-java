#!/usr/bin/env bash
set -Eeuo pipefail

repository_dir="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd -P)"
generator_image="openapitools/openapi-generator-cli:v7.24.0@sha256:5bf3dc75f764c584da8e3344c51b2f3f1e74703461d46a035b5ac1d31515cc88"

cd "${repository_dir}"
sdk_version="$(python3 -c 'import json; print(json.load(open(".openapi/openapi.json", encoding="utf-8"))["info"]["version"])')"
if [[ -f .openapi-generator/FILES ]]; then
  while IFS= read -r generated_file; do
    [[ -z "${generated_file}" ]] && continue
    case "${generated_file}" in
      /*|*../*|README.md|USAGE.md|LICENSE|CONTRIBUTING.md|.github/*|.openapi/*|scripts/*)
        continue
        ;;
    esac
    [[ -f "${generated_file}" || -L "${generated_file}" ]] && rm -f -- "${generated_file}"
  done < .openapi-generator/FILES
fi

docker run --rm \
  --user "$(id -u):$(id -g)" \
  --volume "${repository_dir}:/local" \
  "${generator_image}" generate \
  --input-spec /local/.openapi/openapi.json \
  --generator-name java \
  --config /local/.openapi/config.yaml \
  --output /local \
  --git-user-id x402api-com \
  --git-repo-id x402api-java \
  --additional-properties "artifactVersion=${sdk_version}" \
  --global-property apiTests=false,modelTests=false

python3 scripts/normalize-generated.py
chmod +x gradlew
