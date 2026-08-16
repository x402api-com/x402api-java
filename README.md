# com.x402api:x402api-java

Official java server SDK for the x402api public API.

This repository is generated from the versioned public OpenAPI contract at
`https://api.x402api.com/openapi/openapi.json`. SDK releases are prepared from
an immutable Speakeasy registry tag only after the deployed production contract
matches the source artifact byte-for-byte at the JSON data-model level.

Do not edit generated code until the first Speakeasy generation has completed.
After that point, intentional custom code is preserved by Speakeasy persistent
edits. In particular, cursor-page helpers may read only the documented `Link`
and `X-X402API-Next-Cursor` response headers and must treat cursor values as
opaque.

## Release policy

- All five official SDKs use the same stable SemVer as the public API contract.
- Backward-compatible production contracts may publish automatically.
- Breaking contracts require a new major version and explicit source-repository
  approval.
- The source contract SHA and production digest are recorded in every generation
  workflow run.

Licensed under the MIT License.
