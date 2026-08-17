# FacilitatorDiscoveryApi

All URIs are relative to *https://api.x402api.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**facilitatorSupportedRetrieve**](FacilitatorDiscoveryApi.md#facilitatorSupportedRetrieve) | **GET** /v1/facilitator/supported |  |


<a id="facilitatorSupportedRetrieve"></a>
# **facilitatorSupportedRetrieve**
> SupportedResponse facilitatorSupportedRetrieve()



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.models.*;
import com.x402api.client.api.FacilitatorDiscoveryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    FacilitatorDiscoveryApi apiInstance = new FacilitatorDiscoveryApi(defaultClient);
    try {
      SupportedResponse result = apiInstance.facilitatorSupportedRetrieve();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FacilitatorDiscoveryApi#facilitatorSupportedRetrieve");
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

[**SupportedResponse**](SupportedResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
