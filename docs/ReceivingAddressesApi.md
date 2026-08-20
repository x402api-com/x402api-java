# ReceivingAddressesApi

All URIs are relative to *https://api.x402api.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**receivingAddressesActivate**](ReceivingAddressesApi.md#receivingAddressesActivate) | **POST** /v1/receiving-addresses/{readiness_id}/activate | Activate a receiving address |
| [**receivingAddressesCreateControlChallenge**](ReceivingAddressesApi.md#receivingAddressesCreateControlChallenge) | **POST** /v1/receiving-address-control-challenges | Create a receiving-address control challenge |
| [**receivingAddressesGetControlCapabilities**](ReceivingAddressesApi.md#receivingAddressesGetControlCapabilities) | **GET** /v1/receiving-address-control-capabilities | Get receiving-address control capabilities |
| [**receivingAddressesList**](ReceivingAddressesApi.md#receivingAddressesList) | **GET** /v1/receiving-addresses | List receiving addresses |
| [**receivingAddressesRefreshReadiness**](ReceivingAddressesApi.md#receivingAddressesRefreshReadiness) | **POST** /v1/receiving-addresses/{readiness_id}/readiness-refreshes | Refresh receiving-address readiness |
| [**receivingAddressesRegister**](ReceivingAddressesApi.md#receivingAddressesRegister) | **POST** /v1/receiving-addresses | Register a receiving address |
| [**receivingAddressesRotate**](ReceivingAddressesApi.md#receivingAddressesRotate) | **POST** /v1/receiving-addresses/{readiness_id}/rotations | Rotate a receiving address |


<a id="receivingAddressesActivate"></a>
# **receivingAddressesActivate**
> ExternalReceivingAddress receivingAddressesActivate(idempotencyKey, readinessId)

Activate a receiving address

Activate a ready external receiving-address registration idempotently.

### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.ReceivingAddressesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    ReceivingAddressesApi apiInstance = new ReceivingAddressesApi(defaultClient);
    String idempotencyKey = "idempotencyKey_example"; // String | Caller-persisted mutation key containing 8 to 160 safe ASCII characters. Replay the exact key and body after an uncertain outcome.
    UUID readinessId = UUID.randomUUID(); // UUID |
    try {
      ExternalReceivingAddress result = apiInstance.receivingAddressesActivate(idempotencyKey, readinessId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReceivingAddressesApi#receivingAddressesActivate");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **idempotencyKey** | **String**| Caller-persisted mutation key containing 8 to 160 safe ASCII characters. Replay the exact key and body after an uncertain outcome. | |
| **readinessId** | **UUID**|  | |

### Return type

[**ExternalReceivingAddress**](ExternalReceivingAddress.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response for activate a receiving address. |  * X-Request-ID -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |

<a id="receivingAddressesCreateControlChallenge"></a>
# **receivingAddressesCreateControlChallenge**
> ExternalAddressControlChallenge receivingAddressesCreateControlChallenge(idempotencyKey, externalAddressControlChallengeCreate)

Create a receiving-address control challenge

Create an idempotent proof-of-control challenge for an external receiving address.

### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.ReceivingAddressesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    ReceivingAddressesApi apiInstance = new ReceivingAddressesApi(defaultClient);
    String idempotencyKey = "idempotencyKey_example"; // String | Caller-persisted mutation key containing 8 to 160 safe ASCII characters. Replay the exact key and body after an uncertain outcome.
    ExternalAddressControlChallengeCreate externalAddressControlChallengeCreate = new ExternalAddressControlChallengeCreate(); // ExternalAddressControlChallengeCreate |
    try {
      ExternalAddressControlChallenge result = apiInstance.receivingAddressesCreateControlChallenge(idempotencyKey, externalAddressControlChallengeCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReceivingAddressesApi#receivingAddressesCreateControlChallenge");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **idempotencyKey** | **String**| Caller-persisted mutation key containing 8 to 160 safe ASCII characters. Replay the exact key and body after an uncertain outcome. | |
| **externalAddressControlChallengeCreate** | [**ExternalAddressControlChallengeCreate**](ExternalAddressControlChallengeCreate.md)|  | |

### Return type

[**ExternalAddressControlChallenge**](ExternalAddressControlChallenge.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Successful response for create a receiving-address control challenge. |  * X-Request-ID -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |

<a id="receivingAddressesGetControlCapabilities"></a>
# **receivingAddressesGetControlCapabilities**
> ExternalAddressControlCapabilities receivingAddressesGetControlCapabilities()

Get receiving-address control capabilities

Return the supported proof and control capabilities for external receiving addresses.

### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.ReceivingAddressesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    ReceivingAddressesApi apiInstance = new ReceivingAddressesApi(defaultClient);
    try {
      ExternalAddressControlCapabilities result = apiInstance.receivingAddressesGetControlCapabilities();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReceivingAddressesApi#receivingAddressesGetControlCapabilities");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ExternalAddressControlCapabilities**](ExternalAddressControlCapabilities.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response for get receiving-address control capabilities. |  * X-Request-ID -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |

<a id="receivingAddressesList"></a>
# **receivingAddressesList**
> List&lt;ExternalReceivingAddress&gt; receivingAddressesList(cursor, pageSize)

List receiving addresses

List tenant receiving-address registrations using opaque cursor pagination.

### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.ReceivingAddressesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    ReceivingAddressesApi apiInstance = new ReceivingAddressesApi(defaultClient);
    String cursor = "cursor_example"; // String | Opaque pagination cursor from X-X402API-Next-Cursor or rel=next Link.
    Integer pageSize = 100; // Integer | Number of results in the bounded array page (default and maximum 100).
    try {
      List<ExternalReceivingAddress> result = apiInstance.receivingAddressesList(cursor, pageSize);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReceivingAddressesApi#receivingAddressesList");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **cursor** | **String**| Opaque pagination cursor from X-X402API-Next-Cursor or rel&#x3D;next Link. | [optional] |
| **pageSize** | **Integer**| Number of results in the bounded array page (default and maximum 100). | [optional] [default to 100] |

### Return type

[**List&lt;ExternalReceivingAddress&gt;**](ExternalReceivingAddress.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response for list receiving addresses. |  * X-Request-ID -  <br>  * Link -  <br>  * X-X402API-Next-Cursor -  <br>  * X-X402API-Result-Truncated -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |

<a id="receivingAddressesRefreshReadiness"></a>
# **receivingAddressesRefreshReadiness**
> ExternalReceivingAddress receivingAddressesRefreshReadiness(idempotencyKey, readinessId)

Refresh receiving-address readiness

Request an idempotent refresh of external receiving-address readiness evidence.

### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.ReceivingAddressesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    ReceivingAddressesApi apiInstance = new ReceivingAddressesApi(defaultClient);
    String idempotencyKey = "idempotencyKey_example"; // String | Caller-persisted mutation key containing 8 to 160 safe ASCII characters. Replay the exact key and body after an uncertain outcome.
    UUID readinessId = UUID.randomUUID(); // UUID |
    try {
      ExternalReceivingAddress result = apiInstance.receivingAddressesRefreshReadiness(idempotencyKey, readinessId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReceivingAddressesApi#receivingAddressesRefreshReadiness");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **idempotencyKey** | **String**| Caller-persisted mutation key containing 8 to 160 safe ASCII characters. Replay the exact key and body after an uncertain outcome. | |
| **readinessId** | **UUID**|  | |

### Return type

[**ExternalReceivingAddress**](ExternalReceivingAddress.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response for refresh receiving-address readiness. |  * X-Request-ID -  <br>  |
| **201** | Successful response for refresh receiving-address readiness. |  * X-Request-ID -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |

<a id="receivingAddressesRegister"></a>
# **receivingAddressesRegister**
> ExternalReceivingAddress receivingAddressesRegister(idempotencyKey, externalReceivingAddressCreate)

Register a receiving address

Register a proven external receiving address without transferring wallet custody.

### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.ReceivingAddressesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    ReceivingAddressesApi apiInstance = new ReceivingAddressesApi(defaultClient);
    String idempotencyKey = "idempotencyKey_example"; // String | Caller-persisted mutation key containing 8 to 160 safe ASCII characters. Replay the exact key and body after an uncertain outcome.
    ExternalReceivingAddressCreate externalReceivingAddressCreate = new ExternalReceivingAddressCreate(); // ExternalReceivingAddressCreate |
    try {
      ExternalReceivingAddress result = apiInstance.receivingAddressesRegister(idempotencyKey, externalReceivingAddressCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReceivingAddressesApi#receivingAddressesRegister");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **idempotencyKey** | **String**| Caller-persisted mutation key containing 8 to 160 safe ASCII characters. Replay the exact key and body after an uncertain outcome. | |
| **externalReceivingAddressCreate** | [**ExternalReceivingAddressCreate**](ExternalReceivingAddressCreate.md)|  | |

### Return type

[**ExternalReceivingAddress**](ExternalReceivingAddress.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Successful response for register a receiving address. |  * X-Request-ID -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |

<a id="receivingAddressesRotate"></a>
# **receivingAddressesRotate**
> ExternalReceivingAddress receivingAddressesRotate(idempotencyKey, readinessId, externalReceivingAddressRotation)

Rotate a receiving address

Create an idempotent receiving-address rotation from a proven replacement.

### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.ReceivingAddressesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    ReceivingAddressesApi apiInstance = new ReceivingAddressesApi(defaultClient);
    String idempotencyKey = "idempotencyKey_example"; // String | Caller-persisted mutation key containing 8 to 160 safe ASCII characters. Replay the exact key and body after an uncertain outcome.
    UUID readinessId = UUID.randomUUID(); // UUID |
    ExternalReceivingAddressRotation externalReceivingAddressRotation = new ExternalReceivingAddressRotation(); // ExternalReceivingAddressRotation |
    try {
      ExternalReceivingAddress result = apiInstance.receivingAddressesRotate(idempotencyKey, readinessId, externalReceivingAddressRotation);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReceivingAddressesApi#receivingAddressesRotate");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **idempotencyKey** | **String**| Caller-persisted mutation key containing 8 to 160 safe ASCII characters. Replay the exact key and body after an uncertain outcome. | |
| **readinessId** | **UUID**|  | |
| **externalReceivingAddressRotation** | [**ExternalReceivingAddressRotation**](ExternalReceivingAddressRotation.md)|  | |

### Return type

[**ExternalReceivingAddress**](ExternalReceivingAddress.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Successful response for rotate a receiving address. |  * X-Request-ID -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |
