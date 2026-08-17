# Java usage guide

The [README](README.md) contains installation instructions and the complete function index. This guide focuses on safe production patterns.

## Create and reuse a client

Create one `ApiClient` per credential scope and reuse it so OkHttp can pool connections.

```java
ApiClient client = new ApiClient();
client.setBasePath("https://api.x402api.com");

HttpBearerAuth auth =
    (HttpBearerAuth) client.getAuthentication("tenantApiKey");
auth.setBearerToken(System.getenv("X402API_TENANT_API_KEY"));

client.setHttpClient(
    client.getHttpClient().newBuilder()
        .connectTimeout(3, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build());
```

Avoid changing bearer credentials on a shared client while requests are in flight. Use distinct clients when your service acts for multiple tenants.

## Create and retrieve a charge

```java
DynamicChargeCreate request = new DynamicChargeCreate()
    .resourceVersionId(
        UUID.fromString("00000000-0000-4000-8000-000000000001"))
    .resourceUrl(URI.create(
        "https://merchant.example.com/premium-report"))
    .prices(List.of(
        new DynamicChargePrice()
            .assetId("base_usdc")
            .amountAtomic("1000000")))
    .expiresInSeconds(900)
    .metadata(Map.of("order_id", "order-123"));

ProgrammaticChargesApi chargesApi =
    new ProgrammaticChargesApi(client);

String idempotencyKey = "charge-order-123-v1";
DynamicChargeResponse charge =
    chargesApi.chargesCreate(idempotencyKey, request);

DynamicChargeResponse sameCharge =
    chargesApi.chargesRetrieve(charge.getChargeId());
```

Prices use atomic-unit strings, not floating point. For example, `"1000000"` represents one token for an asset with six decimals.

## Pagination and HTTP headers

Use `WithHttpInfo` when you need response headers or status metadata.

```java
OrdersAndPaymentsApi paymentsApi =
    new OrdersAndPaymentsApi(client);
String cursor = null;

do {
    ApiResponse<List<SettlementJob>> response =
        paymentsApi.paymentsListWithHttpInfo(cursor, 100);

    for (SettlementJob payment : response.getData()) {
        process(payment);
    }

    List<String> cursors =
        response.getHeaders().get("X-X402API-Next-Cursor");
    cursor = cursors == null || cursors.isEmpty()
        ? null
        : cursors.get(0);
} while (cursor != null);
```

Treat the cursor as opaque and pass it back unchanged. The same pattern applies to orders, payment observations, receiving addresses, resources, and resource versions.

## Error handling

```java
try {
    SettlementJob payment = paymentsApi.paymentsRetrieve(paymentId);
} catch (ApiException error) {
    List<String> requestIds = error.getResponseHeaders() == null
        ? null
        : error.getResponseHeaders().get("X-Request-ID");

    if (error.getCode() == 404) {
        handleNotFound();
    } else if (error.getCode() == 429) {
        handleRateLimit(error.getResponseHeaders());
    } else {
        logApiError(
            error.getCode(),
            error.getResponseBody(),
            requestIds);
        throw error;
    }
}
```

Request-model validation and required-parameter checks may throw before network I/O. HTTP errors expose status, headers, and the raw body through `ApiException`.

## Idempotency and retries

Mutations require keys of 8-160 characters matching `[A-Za-z0-9._:-]+`. Persist the key with the intent you are executing.

- New intended mutation: generate a new key.
- Timeout or connection reset after sending: retry the identical body with the same key.
- Known validation failure: fix the request and use a new key.
- Uncertain durable outcome: call `new IdempotencyApi(client).idempotencyGetOutcome(key)`.

The SDK does not retry automatically. Bound application retries, use exponential backoff with jitter, respect `Retry-After`, and normally retry only connection failures plus HTTP `408`, `429`, `500`, `502`, `503`, and `504`.

## Asynchronous calls

Each operation has an `Async` variant that accepts an `ApiCallback<T>`:

```java
chargesApi.chargesRetrieveAsync(chargeId, new ApiCallback<>() {
    @Override
    public void onSuccess(
        DynamicChargeResponse result,
        int statusCode,
        Map<String, List<String>> headers) {
        process(result);
    }

    @Override
    public void onFailure(
        ApiException error,
        int statusCode,
        Map<String, List<String>> headers) {
        handleFailure(error);
    }

    @Override
    public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {}

    @Override
    public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {}
});
```

## Public endpoints

These endpoints do not need a tenant key:

```java
ApiClient publicClient = new ApiClient();
SupportedResponse supported =
    new FacilitatorDiscoveryApi(publicClient).facilitatorGetSupported();
ReceiptVerificationKeyHistory keys =
    new OrdersAndPaymentsApi(publicClient)
        .receiptVerificationKeysRetrieve();
```

Do not edit generated files under `src/main/` or `docs/`; update the OpenAPI contract or generator configuration instead.
