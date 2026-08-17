# x402api Java SDK

Official server-side Java client for the [x402api public API](https://api.x402api.com/openapi/openapi.json). It provides typed request and response models for programmatic x402 charges, resources, receiving addresses, payments, receipts, and wallet balances.

The artifact coordinates are `com.x402api:x402api-java:1.0.0`, the package root is `com.x402api.client`, and the client targets Java 17+. It uses OkHttp and Gson. The production base URL is `https://api.x402api.com`.

> Package registry publishing is separate from SDK generation. Until the first Maven Central release is available, build and install from this repository.

## Installation

After a release is published to Maven Central:

```xml
<dependency>
  <groupId>com.x402api</groupId>
  <artifactId>x402api-java</artifactId>
  <version>1.0.0</version>
</dependency>
```

Install the current source into your local Maven repository:

```bash
git clone https://github.com/x402api-com/x402api-java.git
cd x402api-java
mvn install
```

The repository also includes Gradle, SBT, and Maven build definitions.

## Authentication

Create a scoped tenant API key and configure the generated bearer authentication. Keep it in a server-side secret store; do not ship tenant credentials in browser, mobile, or desktop applications.

```java
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.HttpBearerAuth;

ApiClient client = Configuration.getDefaultApiClient();
client.setBasePath("https://api.x402api.com");

HttpBearerAuth tenantAuth =
    (HttpBearerAuth) client.getAuthentication("tenantApiKey");
tenantAuth.setBearerToken(System.getenv("X402API_TENANT_API_KEY"));
```

`facilitatorGetSupported()` and `receiptVerificationKeysRetrieve()` are public and may be called without a token. All other operations use tenant bearer authentication.

## Quick start: create a charge

```java
import com.x402api.client.api.ProgrammaticChargesApi;
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.HttpBearerAuth;
import com.x402api.client.model.DynamicChargeCreate;
import com.x402api.client.model.DynamicChargePrice;
import com.x402api.client.model.DynamicChargeResponse;
import java.net.URI;
import java.util.List;
import java.util.UUID;

ApiClient client = Configuration.getDefaultApiClient();
client.setBasePath("https://api.x402api.com");
HttpBearerAuth auth =
    (HttpBearerAuth) client.getAuthentication("tenantApiKey");
auth.setBearerToken(System.getenv("X402API_TENANT_API_KEY"));

DynamicChargeCreate request = new DynamicChargeCreate()
    .resourceVersionId(
        UUID.fromString("00000000-0000-4000-8000-000000000001"))
    .resourceUrl(URI.create(
        "https://merchant.example.com/premium-report"))
    .prices(List.of(
        new DynamicChargePrice()
            .assetId("base_usdc")
            .amountAtomic("1000000")))
    .expiresInSeconds(900);

try {
    DynamicChargeResponse charge = new ProgrammaticChargesApi(client)
        .chargesCreate("charge-example-001", request);
    System.out.println(charge);
} catch (ApiException error) {
    System.err.printf("x402api status=%d body=%s%n",
        error.getCode(), error.getResponseBody());
    throw error;
}
```

The first argument to `chargesCreate` is the `Idempotency-Key`. Use a new key for each intended mutation. If the outcome is uncertain, retry the identical payload with the same key.

## Response metadata and pagination

Normal methods return the decoded model. Add `WithHttpInfo` to receive the decoded value, status code, and headers:

```java
import com.x402api.client.api.OrdersAndPaymentsApi;
import com.x402api.client.core.ApiResponse;
import com.x402api.client.model.SettlementJob;
import java.util.List;

OrdersAndPaymentsApi paymentsApi = new OrdersAndPaymentsApi(client);
ApiResponse<List<SettlementJob>> response =
    paymentsApi.paymentsListWithHttpInfo(null, 25);

for (SettlementJob payment : response.getData()) {
    System.out.println(payment);
}

List<String> cursors =
    response.getHeaders().get("X-X402API-Next-Cursor");
if (cursors != null && !cursors.isEmpty()) {
    List<SettlementJob> nextPage =
        paymentsApi.paymentsList(cursors.get(0), 25);
}
```

Cursors are opaque. Pass them back unchanged; do not decode or construct them. Configure connect, read, and write timeouts on `client.getHttpClient().newBuilder()` and pass the rebuilt OkHttp client to `client.setHttpClient(...)`.

The client does not retry automatically. For connection failures and HTTP `408`, `429`, `500`, `502`, `503`, or `504`, add bounded exponential backoff in your application. Respect `Retry-After`, and preserve the same idempotency key and body when retrying a mutation. `ApiException` exposes the status through `getCode()`, the body through `getResponseBody()`, and headers through `getResponseHeaders()`.

## API classes and functions

Every function also has `WithHttpInfo` and asynchronous `Async` variants. Links lead to generated parameter, response, and status-code documentation.

| API class | Function | HTTP endpoint |
| --- | --- | --- |
| [`ProgrammaticChargesApi`](docs/ProgrammaticChargesApi.md) | `chargesCreate(idempotencyKey, dynamicChargeCreate)` | `POST /v1/charges` |
| [`ProgrammaticChargesApi`](docs/ProgrammaticChargesApi.md) | `chargesRetrieve(chargeId)` | `GET /v1/charges/{charge_id}` |
| [`FacilitatorDiscoveryApi`](docs/FacilitatorDiscoveryApi.md) | `facilitatorGetSupported()` | `GET /v1/facilitator/supported` |
| [`IdempotencyApi`](docs/IdempotencyApi.md) | `idempotencyGetOutcome(idempotencyKey)` | `GET /v1/idempotency-outcomes/{idempotency_key}` |
| [`ResourcesAndPricingApi`](docs/ResourcesAndPricingApi.md) | `networkFeesCreateQuote(networkFeePreview)` | `POST /v1/network-fee-quotes` |
| [`OrdersAndPaymentsApi`](docs/OrdersAndPaymentsApi.md) | `ordersList(cursor, pageSize)` | `GET /v1/orders` |
| [`OrdersAndPaymentsApi`](docs/OrdersAndPaymentsApi.md) | `ordersRetrieve(id)` | `GET /v1/orders/{id}` |
| [`AssetsAndPaymentControlsApi`](docs/AssetsAndPaymentControlsApi.md) | `paymentReadinessRetrieve()` | `GET /v1/payment-readiness` |
| [`OrdersAndPaymentsApi`](docs/OrdersAndPaymentsApi.md) | `paymentsList(cursor, pageSize)` | `GET /v1/payments` |
| [`OrdersAndPaymentsApi`](docs/OrdersAndPaymentsApi.md) | `paymentsRetrieve(id)` | `GET /v1/payments/{id}` |
| [`OrdersAndPaymentsApi`](docs/OrdersAndPaymentsApi.md) | `paymentsListObservations(id, cursor, pageSize)` | `GET /v1/payments/{id}/observations` |
| [`OrdersAndPaymentsApi`](docs/OrdersAndPaymentsApi.md) | `paymentsRetrieveReceipt(id)` | `GET /v1/payments/{id}/receipt` |
| [`OrdersAndPaymentsApi`](docs/OrdersAndPaymentsApi.md) | `receiptVerificationKeysRetrieve()` | `GET /v1/payment-receipt-verification-keys` |
| [`ReceivingAddressesApi`](docs/ReceivingAddressesApi.md) | `receivingAddressesGetControlCapabilities()` | `GET /v1/receiving-address-control-capabilities` |
| [`ReceivingAddressesApi`](docs/ReceivingAddressesApi.md) | `receivingAddressesCreateControlChallenge(idempotencyKey, body)` | `POST /v1/receiving-address-control-challenges` |
| [`ReceivingAddressesApi`](docs/ReceivingAddressesApi.md) | `receivingAddressesList(cursor, pageSize)` | `GET /v1/receiving-addresses` |
| [`ReceivingAddressesApi`](docs/ReceivingAddressesApi.md) | `receivingAddressesRegister(idempotencyKey, body)` | `POST /v1/receiving-addresses` |
| [`ReceivingAddressesApi`](docs/ReceivingAddressesApi.md) | `receivingAddressesActivate(idempotencyKey, readinessId)` | `POST /v1/receiving-addresses/{readiness_id}/activate` |
| [`ReceivingAddressesApi`](docs/ReceivingAddressesApi.md) | `receivingAddressesRefreshReadiness(idempotencyKey, readinessId)` | `POST /v1/receiving-addresses/{readiness_id}/readiness-refreshes` |
| [`ReceivingAddressesApi`](docs/ReceivingAddressesApi.md) | `receivingAddressesRotate(idempotencyKey, readinessId, body)` | `POST /v1/receiving-addresses/{readiness_id}/rotations` |
| [`ResourcesAndPricingApi`](docs/ResourcesAndPricingApi.md) | `resourcesList(cursor, pageSize)` | `GET /v1/resources` |
| [`ResourcesAndPricingApi`](docs/ResourcesAndPricingApi.md) | `resourcesCreate(idempotencyKey, resourceCreate)` | `POST /v1/resources` |
| [`ResourcesAndPricingApi`](docs/ResourcesAndPricingApi.md) | `resourcesListVersions(resourceId, cursor, pageSize)` | `GET /v1/resources/{resource_id}/versions` |
| [`ResourcesAndPricingApi`](docs/ResourcesAndPricingApi.md) | `resourcesCreateVersion(idempotencyKey, resourceId, body)` | `POST /v1/resources/{resource_id}/versions` |
| [`ResourcesAndPricingApi`](docs/ResourcesAndPricingApi.md) | `resourcesActivateVersion(idempotencyKey, resourceId, versionId, body)` | `POST /v1/resources/{resource_id}/versions/{version_id}/activate` |
| [`ResourcesAndPricingApi`](docs/ResourcesAndPricingApi.md) | `resourcesRetireVersion(idempotencyKey, resourceId, versionId, body)` | `POST /v1/resources/{resource_id}/versions/{version_id}/retire` |
| [`WalletsAndTransfersApi`](docs/WalletsAndTransfersApi.md) | `walletsRetrieveBalance(id, finality)` | `GET /v1/wallets/{id}/balances` |

All request and response model documentation is in [`docs/`](docs/). See [`USAGE.md`](USAGE.md) for more complete patterns.

## Automatic generation

This repository uses OpenAPI Generator 7.24.0, pinned by Docker image and digest in [`scripts/generate-sdk.sh`](scripts/generate-sdk.sh). The [`SDK generation workflow`](.github/workflows/sdk_generation.yaml) checks the live OpenAPI document hourly and on manual or repository dispatch. When its normalized contract changes, GitHub Actions regenerates, validates, and commits the SDK to `main`.

To regenerate and validate locally with Docker and Java 17:

```bash
./scripts/generate-sdk.sh
./gradlew test
```

Persistent files such as this README, `USAGE.md`, workflow configuration, and generator scripts are protected by [`.openapi-generator-ignore`](.openapi-generator-ignore). Generated client and model files should not be edited manually.

Licensed under the [MIT License](LICENSE).
