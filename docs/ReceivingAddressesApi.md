# ReceivingAddressesApi

All URIs are relative to *https://api.x402api.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**receivingAddressesGetControlCapabilities**](ReceivingAddressesApi.md#receivingAddressesGetControlCapabilities) | **GET** /v1/receiving-address-control-capabilities | Get receiving-address control capabilities |
| [**receivingAddressesList**](ReceivingAddressesApi.md#receivingAddressesList) | **GET** /v1/receiving-addresses | List receiving addresses |


<a id="receivingAddressesGetControlCapabilities"></a>
# **receivingAddressesGetControlCapabilities**
> ExternalAddressControlCapabilities receivingAddressesGetControlCapabilities()

Get receiving-address control capabilities

Return the supported proof and control capabilities for external receiving addresses. Requires a tenant API key with the &#x60;wallets:read&#x60; scope.

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

List tenant receiving-address registrations using opaque cursor pagination. Requires a tenant API key with the &#x60;wallets:read&#x60; scope.

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
