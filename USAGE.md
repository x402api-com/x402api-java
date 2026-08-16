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
