# OrdersAndPaymentsApi

All URIs are relative to *https://api.x402api.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**v1OrdersList**](OrdersAndPaymentsApi.md#v1OrdersList) | **GET** /v1/orders |  |
| [**v1OrdersRetrieve**](OrdersAndPaymentsApi.md#v1OrdersRetrieve) | **GET** /v1/orders/{id} |  |
| [**v1PaymentReceiptVerificationKeysRetrieve**](OrdersAndPaymentsApi.md#v1PaymentReceiptVerificationKeysRetrieve) | **GET** /v1/payment-receipt-verification-keys |  |
| [**v1PaymentsList**](OrdersAndPaymentsApi.md#v1PaymentsList) | **GET** /v1/payments |  |
| [**v1PaymentsObservationsList**](OrdersAndPaymentsApi.md#v1PaymentsObservationsList) | **GET** /v1/payments/{id}/observations |  |
| [**v1PaymentsReceiptRetrieve**](OrdersAndPaymentsApi.md#v1PaymentsReceiptRetrieve) | **GET** /v1/payments/{id}/receipt |  |
| [**v1PaymentsRetrieve**](OrdersAndPaymentsApi.md#v1PaymentsRetrieve) | **GET** /v1/payments/{id} |  |


<a id="v1OrdersList"></a>
# **v1OrdersList**
> List&lt;Order&gt; v1OrdersList(cursor, pageSize)



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.OrdersAndPaymentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    OrdersAndPaymentsApi apiInstance = new OrdersAndPaymentsApi(defaultClient);
    String cursor = "cursor_example"; // String | Opaque pagination cursor from X-X402API-Next-Cursor or rel=next Link.
    Integer pageSize = 100; // Integer | Number of results in the bounded array page (default and maximum 100).
    try {
      List<Order> result = apiInstance.v1OrdersList(cursor, pageSize);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersAndPaymentsApi#v1OrdersList");
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

[**List&lt;Order&gt;**](Order.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |

<a id="v1OrdersRetrieve"></a>
# **v1OrdersRetrieve**
> Order v1OrdersRetrieve(id)



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.OrdersAndPaymentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    OrdersAndPaymentsApi apiInstance = new OrdersAndPaymentsApi(defaultClient);
    UUID id = UUID.randomUUID(); // UUID |
    try {
      Order result = apiInstance.v1OrdersRetrieve(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersAndPaymentsApi#v1OrdersRetrieve");
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

### Return type

[**Order**](Order.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |

<a id="v1PaymentReceiptVerificationKeysRetrieve"></a>
# **v1PaymentReceiptVerificationKeysRetrieve**
> ReceiptVerificationKeyHistory v1PaymentReceiptVerificationKeysRetrieve()



Public key history; authenticity still requires an out-of-band pin.

### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.models.*;
import com.x402api.client.api.OrdersAndPaymentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    OrdersAndPaymentsApi apiInstance = new OrdersAndPaymentsApi(defaultClient);
    try {
      ReceiptVerificationKeyHistory result = apiInstance.v1PaymentReceiptVerificationKeysRetrieve();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersAndPaymentsApi#v1PaymentReceiptVerificationKeysRetrieve");
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

[**ReceiptVerificationKeyHistory**](ReceiptVerificationKeyHistory.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |

<a id="v1PaymentsList"></a>
# **v1PaymentsList**
> List&lt;SettlementJob&gt; v1PaymentsList(cursor, pageSize)



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.OrdersAndPaymentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    OrdersAndPaymentsApi apiInstance = new OrdersAndPaymentsApi(defaultClient);
    String cursor = "cursor_example"; // String | Opaque pagination cursor from X-X402API-Next-Cursor or rel=next Link.
    Integer pageSize = 100; // Integer | Number of results in the bounded array page (default and maximum 100).
    try {
      List<SettlementJob> result = apiInstance.v1PaymentsList(cursor, pageSize);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersAndPaymentsApi#v1PaymentsList");
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

[**List&lt;SettlementJob&gt;**](SettlementJob.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |

<a id="v1PaymentsObservationsList"></a>
# **v1PaymentsObservationsList**
> List&lt;SettlementChainObservation&gt; v1PaymentsObservationsList(id, cursor, pageSize)



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.OrdersAndPaymentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    OrdersAndPaymentsApi apiInstance = new OrdersAndPaymentsApi(defaultClient);
    UUID id = UUID.randomUUID(); // UUID |
    String cursor = "cursor_example"; // String | Opaque pagination cursor from X-X402API-Next-Cursor or rel=next Link.
    Integer pageSize = 100; // Integer | Number of results in the bounded array page (default and maximum 100).
    try {
      List<SettlementChainObservation> result = apiInstance.v1PaymentsObservationsList(id, cursor, pageSize);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersAndPaymentsApi#v1PaymentsObservationsList");
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
| **cursor** | **String**| Opaque pagination cursor from X-X402API-Next-Cursor or rel&#x3D;next Link. | [optional] |
| **pageSize** | **Integer**| Number of results in the bounded array page (default and maximum 100). | [optional] [default to 100] |

### Return type

[**List&lt;SettlementChainObservation&gt;**](SettlementChainObservation.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |

<a id="v1PaymentsReceiptRetrieve"></a>
# **v1PaymentsReceiptRetrieve**
> PaymentReceipt v1PaymentsReceiptRetrieve(id)



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.OrdersAndPaymentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    OrdersAndPaymentsApi apiInstance = new OrdersAndPaymentsApi(defaultClient);
    UUID id = UUID.randomUUID(); // UUID |
    try {
      PaymentReceipt result = apiInstance.v1PaymentsReceiptRetrieve(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersAndPaymentsApi#v1PaymentsReceiptRetrieve");
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

### Return type

[**PaymentReceipt**](PaymentReceipt.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |

<a id="v1PaymentsRetrieve"></a>
# **v1PaymentsRetrieve**
> SettlementJob v1PaymentsRetrieve(id)



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.OrdersAndPaymentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    OrdersAndPaymentsApi apiInstance = new OrdersAndPaymentsApi(defaultClient);
    UUID id = UUID.randomUUID(); // UUID |
    try {
      SettlementJob result = apiInstance.v1PaymentsRetrieve(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersAndPaymentsApi#v1PaymentsRetrieve");
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

### Return type

[**SettlementJob**](SettlementJob.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
