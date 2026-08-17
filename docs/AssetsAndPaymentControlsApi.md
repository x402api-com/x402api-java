# AssetsAndPaymentControlsApi

All URIs are relative to *https://api.x402api.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**paymentReadinessRetrieve**](AssetsAndPaymentControlsApi.md#paymentReadinessRetrieve) | **GET** /v1/payment-readiness | Retrieve payment readiness |


<a id="paymentReadinessRetrieve"></a>
# **paymentReadinessRetrieve**
> PaymentReadiness paymentReadinessRetrieve()

Retrieve payment readiness

Return the tenant&#39;s current external-wallet payment-readiness projection.

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
      PaymentReadiness result = apiInstance.paymentReadinessRetrieve();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AssetsAndPaymentControlsApi#paymentReadinessRetrieve");
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
| **200** | Successful response for retrieve payment readiness. |  * X-Request-ID -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |
