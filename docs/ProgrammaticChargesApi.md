# ProgrammaticChargesApi

All URIs are relative to *https://api.x402api.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createDynamicCharge**](ProgrammaticChargesApi.md#createDynamicCharge) | **POST** /v1/charges |  |
| [**retrieveDynamicCharge**](ProgrammaticChargesApi.md#retrieveDynamicCharge) | **GET** /v1/charges/{charge_id} |  |


<a id="createDynamicCharge"></a>
# **createDynamicCharge**
> DynamicChargeResponse createDynamicCharge(idempotencyKey, dynamicChargeCreate)



Create one idempotent dynamic charge from an active resource template. The immutable challenge freezes exact requested atomic amounts, eligible rails, verified tenant receiving addresses, fee policy and evidence, metadata, and expiry. The caller cannot supply a recipient address.

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
    String idempotencyKey = "idempotencyKey_example"; // String | Unique mutation key; replaying different content returns HTTP 409.
    DynamicChargeCreate dynamicChargeCreate = new DynamicChargeCreate(); // DynamicChargeCreate |
    try {
      DynamicChargeResponse result = apiInstance.createDynamicCharge(idempotencyKey, dynamicChargeCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProgrammaticChargesApi#createDynamicCharge");
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
| **idempotencyKey** | **String**| Unique mutation key; replaying different content returns HTTP 409. | |
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
| **201** |  |  -  |
| **409** |  |  -  |
| **422** |  |  -  |

<a id="retrieveDynamicCharge"></a>
# **retrieveDynamicCharge**
> DynamicChargeResponse retrieveDynamicCharge(chargeId)



Return the tenant-scoped frozen charge terms and current projected status without recomputing prices, recipients, rails, or fee evidence.

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
      DynamicChargeResponse result = apiInstance.retrieveDynamicCharge(chargeId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProgrammaticChargesApi#retrieveDynamicCharge");
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
| **200** |  |  -  |
| **404** |  |  -  |
