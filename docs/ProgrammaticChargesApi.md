# ProgrammaticChargesApi

All URIs are relative to *https://api.x402api.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**chargesCreate**](ProgrammaticChargesApi.md#chargesCreate) | **POST** /v1/charges | Create a programmatic charge |
| [**chargesRetrieve**](ProgrammaticChargesApi.md#chargesRetrieve) | **GET** /v1/charges/{charge_id} | Retrieve a programmatic charge |


<a id="chargesCreate"></a>
# **chargesCreate**
> DynamicChargeResponse chargesCreate(idempotencyKey, dynamicChargeCreate)

Create a programmatic charge

Create one idempotent dynamic charge with immutable x402 payment terms.

### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.ProgrammaticChargesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    ProgrammaticChargesApi apiInstance = new ProgrammaticChargesApi(defaultClient);
    String idempotencyKey = "idempotencyKey_example"; // String | Caller-persisted mutation key containing 8 to 160 safe ASCII characters. Replay the exact key and body after an uncertain outcome.
    DynamicChargeCreate dynamicChargeCreate = new DynamicChargeCreate(); // DynamicChargeCreate |
    try {
      DynamicChargeResponse result = apiInstance.chargesCreate(idempotencyKey, dynamicChargeCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProgrammaticChargesApi#chargesCreate");
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
| **dynamicChargeCreate** | [**DynamicChargeCreate**](DynamicChargeCreate.md)|  | |

### Return type

[**DynamicChargeResponse**](DynamicChargeResponse.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Successful response for create a programmatic charge. |  * X-Request-ID -  <br>  |
| **409** | The request failed. |  * X-Request-ID -  <br>  |
| **422** | The request failed. |  * X-Request-ID -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |

<a id="chargesRetrieve"></a>
# **chargesRetrieve**
> DynamicChargeResponse chargesRetrieve(chargeId)

Retrieve a programmatic charge

Retrieve the frozen terms and current projected status of a tenant charge.

### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.ProgrammaticChargesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    ProgrammaticChargesApi apiInstance = new ProgrammaticChargesApi(defaultClient);
    UUID chargeId = UUID.randomUUID(); // UUID |
    try {
      DynamicChargeResponse result = apiInstance.chargesRetrieve(chargeId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProgrammaticChargesApi#chargesRetrieve");
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
| **chargeId** | **UUID**|  | |

### Return type

[**DynamicChargeResponse**](DynamicChargeResponse.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response for retrieve a programmatic charge. |  * X-Request-ID -  <br>  |
| **404** | The request failed. |  * X-Request-ID -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |
