# AssetsAndPaymentControlsApi

All URIs are relative to *https://api.x402api.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**v1PaymentReadinessRetrieve**](AssetsAndPaymentControlsApi.md#v1PaymentReadinessRetrieve) | **GET** /v1/payment-readiness |  |


<a id="v1PaymentReadinessRetrieve"></a>
# **v1PaymentReadinessRetrieve**
> PaymentReadiness v1PaymentReadinessRetrieve()



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.AssetsAndPaymentControlsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    AssetsAndPaymentControlsApi apiInstance = new AssetsAndPaymentControlsApi(defaultClient);
    try {
      PaymentReadiness result = apiInstance.v1PaymentReadinessRetrieve();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AssetsAndPaymentControlsApi#v1PaymentReadinessRetrieve");
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

[**PaymentReadiness**](PaymentReadiness.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
