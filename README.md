# x402api Java SDK

Official server-side Java SDK for the x402api public API.
The package name is `com.x402api:x402api-java` and the production API endpoint is
`https://api.x402api.com`.

> **Release status:** this repository contains the generation and release
> configuration. The package installation command becomes available when the
> first synchronized SDK release is published.

## Requirements

JDK 17 or newer.

## Installation

Maven:

```xml
<dependency>
  <groupId>com.x402api</groupId>
  <artifactId>x402api-java</artifactId>
  <version>1.0.0</version>
</dependency>
```

Gradle:

```groovy
implementation "com.x402api:x402api-java:1.0.0"
```

## Using the x402api Java SDK

The examples below show the configured public surface. Generated request and
response model names are documented under `docs/` after the first SDK generation.

### Configure authentication

Create a scoped tenant API key in x402api and expose it to the server process as
`X402API_TENANT_API_KEY`. The SDK sends it as a bearer credential. Never embed a
tenant API key in browser, mobile, desktop, or other distributed client code.

### Initialize the client

```java
import com.x402api.sdk.X402Api;

public final class Example {
    public static void main(String[] args) throws Exception {
        X402Api sdk = X402Api.builder()
            .tenantApiKey(System.getenv("X402API_TENANT_API_KEY"))
            .build();

        var readiness = sdk.paymentReadiness().retrieve();
        System.out.println(readiness);
    }
}
```

The idiomatic method shape for this SDK is `sdk.resourceName().methodName(request)`.
All request fields are collected into a typed request object so new optional API
fields do not break existing call sites.

### Create a charge

The logical SDK call is `charges.create`. Supply a unique `Idempotency-Key` for
each intended mutation and reuse the same key only when retrying that exact
request. The request contains a resource-version UUID, the protected URL, one or
more asset prices expressed in atomic units, and an expiry between 30 and 3600
seconds.

The equivalent HTTP request is useful for validating credentials independently
of the SDK:

```bash
curl --request POST https://api.x402api.com/v1/charges \
  --header "Authorization: Bearer $X402API_TENANT_API_KEY" \
  --header "Content-Type: application/json" \
  --header "Idempotency-Key: charge-$(date +%s)" \
  --data '{
    "resource_version_id": "00000000-0000-4000-8000-000000000001",
    "resource_url": "https://merchant.example.com/premium-report",
    "prices": [{
      "asset_id": "base_usdc",
      "amount_atomic": "1000000"
    }],
    "expires_in_seconds": 900,
    "metadata": {"customer_reference": "customer-123"}
  }'
```

### Read payment state and receipts

Use `payments.list` for a tenant-wide view, `payments.retrieve` for one payment,
`payments.listObservations` for chain evidence, and `payments.retrieveReceipt`
for the signed final receipt. Retrieve the public verification-key history with
`receiptVerificationKeys.retrieve` before verifying receipts offline.

### Cursor pagination

`orders.list`, `payments.list`, `payments.listObservations`,
`receivingAddresses.list`, `resources.list`, and `resources.listVersions` accept
`pageSize` (1-100) and an optional opaque `cursor`. Do not decode or construct
cursors. Read the next cursor from `X-X402API-Next-Cursor` or the `Link` response
header and pass it unchanged to the next call.

### Idempotent mutations

Every mutating operation marked in the function table requires an idempotency
key of 8-160 characters matching `[A-Za-z0-9._:-]+`. A transport timeout does
not prove that a mutation failed. Retry the same payload with the same key, or
call `idempotency.getOutcome` to resolve its durable outcome.

### Errors, retries, and HTTP metadata

The SDK raises or returns a typed `X402ApiError` for documented 4xx, 5xx, and
default error responses. Generated responses use the `envelope-http` format so
callers can inspect the decoded body, status code, and response headers. The SDK
applies short exponential-backoff retries to connection failures and status
codes 408, 429, 500, 502, 503, and 504. Application-level retries must still
respect idempotency requirements.


## Available resources and functions

Method names below use the language-neutral generated names. The generator
applies the normal casing conventions for this language.

| SDK resource | Function | HTTP endpoint | Purpose |
| --- | --- | --- | --- |
| `charges` | `create` | `POST /v1/charges` | Create a programmatic charge. Requires an idempotency key. |
| `charges` | `retrieve` | `GET /v1/charges/{charge_id}` | Retrieve a charge by UUID. |
| `facilitator` | `getSupported` | `GET /v1/facilitator/supported` | Discover supported facilitator profiles. |
| `idempotency` | `getOutcome` | `GET /v1/idempotency-outcomes/{idempotency_key}` | Inspect the recorded result for an idempotent mutation. |
| `networkFees` | `createQuote` | `POST /v1/network-fee-quotes` | Preview network fees for one or more prices. |
| `orders` | `list` | `GET /v1/orders` | List orders with cursor pagination. |
| `orders` | `retrieve` | `GET /v1/orders/{id}` | Retrieve an order by UUID. |
| `paymentReadiness` | `retrieve` | `GET /v1/payment-readiness` | Inspect assets and payment-control readiness. |
| `receiptVerificationKeys` | `retrieve` | `GET /v1/payment-receipt-verification-keys` | Retrieve the public receipt-verification key history. |
| `payments` | `list` | `GET /v1/payments` | List payments with cursor pagination. |
| `payments` | `retrieve` | `GET /v1/payments/{id}` | Retrieve a payment by UUID. |
| `payments` | `listObservations` | `GET /v1/payments/{id}/observations` | List chain observations for a payment. |
| `payments` | `retrieveReceipt` | `GET /v1/payments/{id}/receipt` | Retrieve the signed payment receipt. |
| `receivingAddresses` | `getControlCapabilities` | `GET /v1/receiving-address-control-capabilities` | Inspect supported address-control proofs. |
| `receivingAddresses` | `createControlChallenge` | `POST /v1/receiving-address-control-challenges` | Create an address-control challenge. Requires an idempotency key. |
| `receivingAddresses` | `list` | `GET /v1/receiving-addresses` | List receiving addresses with cursor pagination. |
| `receivingAddresses` | `register` | `POST /v1/receiving-addresses` | Register a receiving address. Requires an idempotency key. |
| `receivingAddresses` | `activate` | `POST /v1/receiving-addresses/{readiness_id}/activate` | Activate a ready receiving address. Requires an idempotency key. |
| `receivingAddresses` | `refreshReadiness` | `POST /v1/receiving-addresses/{readiness_id}/readiness-refreshes` | Re-run readiness checks. Requires an idempotency key. |
| `receivingAddresses` | `rotate` | `POST /v1/receiving-addresses/{readiness_id}/rotations` | Rotate a receiving address. Requires an idempotency key. |
| `resources` | `list` | `GET /v1/resources` | List payment-gated resources with cursor pagination. |
| `resources` | `create` | `POST /v1/resources` | Create a payment-gated resource. Requires an idempotency key. |
| `resources` | `listVersions` | `GET /v1/resources/{resource_id}/versions` | List immutable resource versions. |
| `resources` | `createVersion` | `POST /v1/resources/{resource_id}/versions` | Create a resource version. Requires an idempotency key. |
| `resources` | `activateVersion` | `POST /v1/resources/{resource_id}/versions/{version_id}/activate` | Activate a resource version using optimistic concurrency. |
| `resources` | `retireVersion` | `POST /v1/resources/{resource_id}/versions/{version_id}/retire` | Retire a resource version using optimistic concurrency. |
| `wallets` | `retrieveBalance` | `GET /v1/wallets/{id}/balances` | Retrieve confirmed, finalized, or latest wallet balances. |

## Source contract and releases

This repository is generated from the versioned public OpenAPI contract at
[`https://api.x402api.com/openapi/openapi.json`](https://api.x402api.com/openapi/openapi.json).
SDK releases are prepared from an immutable Speakeasy registry tag only after
the deployed production contract matches the source artifact at the JSON data
model level.

- All five official SDKs use the same stable SemVer as the public API contract.
- Backward-compatible production contracts may publish automatically.
- Breaking contracts require a new major version and explicit approval.
- Every generation run records the source Git revision and contract digest.
- `USAGE.md` contains hand-maintained examples that survive regeneration.

## Contributing

Most source files in this repository are generated. Open an issue for API or SDK
feedback. Changes to the public contract, generator configuration, or persistent
documentation should be made in the source repository so they propagate to all
five SDKs consistently.

Licensed under the MIT License.
