# IdempotencyApi

All URIs are relative to *https://api.x402api.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**v1IdempotencyOutcomesRetrieve**](IdempotencyApi.md#v1IdempotencyOutcomesRetrieve) | **GET** /v1/idempotency-outcomes/{idempotency_key} |  |


<a id="v1IdempotencyOutcomesRetrieve"></a>
# **v1IdempotencyOutcomesRetrieve**
> IdempotencyOutcome v1IdempotencyOutcomesRetrieve(idempotencyKey)



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.IdempotencyApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    IdempotencyApi apiInstance = new IdempotencyApi(defaultClient);
    String idempotencyKey = "idempotencyKey_example"; // String |
    try {
      IdempotencyOutcome result = apiInstance.v1IdempotencyOutcomesRetrieve(idempotencyKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IdempotencyApi#v1IdempotencyOutcomesRetrieve");
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
| **idempotencyKey** | **String**|  | |

### Return type

[**IdempotencyOutcome**](IdempotencyOutcome.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
