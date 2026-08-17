# WalletsAndTransfersApi

All URIs are relative to *https://api.x402api.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**v1WalletsBalancesRetrieve**](WalletsAndTransfersApi.md#v1WalletsBalancesRetrieve) | **GET** /v1/wallets/{id}/balances |  |


<a id="v1WalletsBalancesRetrieve"></a>
# **v1WalletsBalancesRetrieve**
> WalletBalanceResponse v1WalletsBalancesRetrieve(id, finality)



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.WalletsAndTransfersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    WalletsAndTransfersApi apiInstance = new WalletsAndTransfersApi(defaultClient);
    UUID id = UUID.randomUUID(); // UUID |
    String finality = "confirmed"; // String |
    try {
      WalletBalanceResponse result = apiInstance.v1WalletsBalancesRetrieve(id, finality);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WalletsAndTransfersApi#v1WalletsBalancesRetrieve");
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
| **id** | **UUID**|  | |
| **finality** | **String**|  | [optional] [default to finalized] [enum: confirmed, finalized, latest] |

### Return type

[**WalletBalanceResponse**](WalletBalanceResponse.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
