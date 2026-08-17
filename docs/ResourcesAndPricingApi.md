# ResourcesAndPricingApi

All URIs are relative to *https://api.x402api.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**v1NetworkFeeQuotesCreate**](ResourcesAndPricingApi.md#v1NetworkFeeQuotesCreate) | **POST** /v1/network-fee-quotes |  |
| [**v1ResourcesCreate**](ResourcesAndPricingApi.md#v1ResourcesCreate) | **POST** /v1/resources |  |
| [**v1ResourcesList**](ResourcesAndPricingApi.md#v1ResourcesList) | **GET** /v1/resources |  |
| [**v1ResourcesVersionsActivateCreate**](ResourcesAndPricingApi.md#v1ResourcesVersionsActivateCreate) | **POST** /v1/resources/{resource_id}/versions/{version_id}/activate |  |
| [**v1ResourcesVersionsCreate**](ResourcesAndPricingApi.md#v1ResourcesVersionsCreate) | **POST** /v1/resources/{resource_id}/versions |  |
| [**v1ResourcesVersionsList**](ResourcesAndPricingApi.md#v1ResourcesVersionsList) | **GET** /v1/resources/{resource_id}/versions |  |
| [**v1ResourcesVersionsRetireCreate**](ResourcesAndPricingApi.md#v1ResourcesVersionsRetireCreate) | **POST** /v1/resources/{resource_id}/versions/{version_id}/retire |  |


<a id="v1NetworkFeeQuotesCreate"></a>
# **v1NetworkFeeQuotesCreate**
> NetworkFeePreviewResponse v1NetworkFeeQuotesCreate(networkFeePreview)



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.ResourcesAndPricingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    ResourcesAndPricingApi apiInstance = new ResourcesAndPricingApi(defaultClient);
    NetworkFeePreview networkFeePreview = new NetworkFeePreview(); // NetworkFeePreview |
    try {
      NetworkFeePreviewResponse result = apiInstance.v1NetworkFeeQuotesCreate(networkFeePreview);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesAndPricingApi#v1NetworkFeeQuotesCreate");
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
| **networkFeePreview** | [**NetworkFeePreview**](NetworkFeePreview.md)|  | |

### Return type

[**NetworkFeePreviewResponse**](NetworkFeePreviewResponse.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |

<a id="v1ResourcesCreate"></a>
# **v1ResourcesCreate**
> Resource v1ResourcesCreate(idempotencyKey, resourceCreate)



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.ResourcesAndPricingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    ResourcesAndPricingApi apiInstance = new ResourcesAndPricingApi(defaultClient);
    String idempotencyKey = "idempotencyKey_example"; // String | Unique mutation key; replaying different content returns HTTP 409.
    ResourceCreate resourceCreate = new ResourceCreate(); // ResourceCreate |
    try {
      Resource result = apiInstance.v1ResourcesCreate(idempotencyKey, resourceCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesAndPricingApi#v1ResourcesCreate");
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
| **resourceCreate** | [**ResourceCreate**](ResourceCreate.md)|  | |

### Return type

[**Resource**](Resource.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  -  |

<a id="v1ResourcesList"></a>
# **v1ResourcesList**
> List&lt;Resource&gt; v1ResourcesList(cursor, pageSize)



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.ResourcesAndPricingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    ResourcesAndPricingApi apiInstance = new ResourcesAndPricingApi(defaultClient);
    String cursor = "cursor_example"; // String | Opaque pagination cursor from X-X402API-Next-Cursor or rel=next Link.
    Integer pageSize = 100; // Integer | Number of results in the bounded array page (default and maximum 100).
    try {
      List<Resource> result = apiInstance.v1ResourcesList(cursor, pageSize);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesAndPricingApi#v1ResourcesList");
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

[**List&lt;Resource&gt;**](Resource.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |

<a id="v1ResourcesVersionsActivateCreate"></a>
# **v1ResourcesVersionsActivateCreate**
> ResourceVersion v1ResourcesVersionsActivateCreate(idempotencyKey, resourceId, versionId, resourceVersionActivate)



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.ResourcesAndPricingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    ResourcesAndPricingApi apiInstance = new ResourcesAndPricingApi(defaultClient);
    String idempotencyKey = "idempotencyKey_example"; // String | Unique mutation key; replaying different content returns HTTP 409.
    UUID resourceId = UUID.randomUUID(); // UUID |
    UUID versionId = UUID.randomUUID(); // UUID |
    ResourceVersionActivate resourceVersionActivate = new ResourceVersionActivate(); // ResourceVersionActivate |
    try {
      ResourceVersion result = apiInstance.v1ResourcesVersionsActivateCreate(idempotencyKey, resourceId, versionId, resourceVersionActivate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesAndPricingApi#v1ResourcesVersionsActivateCreate");
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
| **resourceId** | **UUID**|  | |
| **versionId** | **UUID**|  | |
| **resourceVersionActivate** | [**ResourceVersionActivate**](ResourceVersionActivate.md)|  | |

### Return type

[**ResourceVersion**](ResourceVersion.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **409** |  |  -  |

<a id="v1ResourcesVersionsCreate"></a>
# **v1ResourcesVersionsCreate**
> ResourceVersion v1ResourcesVersionsCreate(idempotencyKey, resourceId, resourceVersionCreate)



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.ResourcesAndPricingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    ResourcesAndPricingApi apiInstance = new ResourcesAndPricingApi(defaultClient);
    String idempotencyKey = "idempotencyKey_example"; // String | Unique mutation key; replaying different content returns HTTP 409.
    UUID resourceId = UUID.randomUUID(); // UUID |
    ResourceVersionCreate resourceVersionCreate = new ResourceVersionCreate(); // ResourceVersionCreate |
    try {
      ResourceVersion result = apiInstance.v1ResourcesVersionsCreate(idempotencyKey, resourceId, resourceVersionCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesAndPricingApi#v1ResourcesVersionsCreate");
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
| **resourceId** | **UUID**|  | |
| **resourceVersionCreate** | [**ResourceVersionCreate**](ResourceVersionCreate.md)|  | |

### Return type

[**ResourceVersion**](ResourceVersion.md)

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

<a id="v1ResourcesVersionsList"></a>
# **v1ResourcesVersionsList**
> List&lt;ResourceVersion&gt; v1ResourcesVersionsList(resourceId, cursor, pageSize)



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.ResourcesAndPricingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    ResourcesAndPricingApi apiInstance = new ResourcesAndPricingApi(defaultClient);
    UUID resourceId = UUID.randomUUID(); // UUID |
    String cursor = "cursor_example"; // String | Opaque pagination cursor from X-X402API-Next-Cursor or rel=next Link.
    Integer pageSize = 100; // Integer | Number of results in the bounded array page (default and maximum 100).
    try {
      List<ResourceVersion> result = apiInstance.v1ResourcesVersionsList(resourceId, cursor, pageSize);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesAndPricingApi#v1ResourcesVersionsList");
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
| **resourceId** | **UUID**|  | |
| **cursor** | **String**| Opaque pagination cursor from X-X402API-Next-Cursor or rel&#x3D;next Link. | [optional] |
| **pageSize** | **Integer**| Number of results in the bounded array page (default and maximum 100). | [optional] [default to 100] |

### Return type

[**List&lt;ResourceVersion&gt;**](ResourceVersion.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |

<a id="v1ResourcesVersionsRetireCreate"></a>
# **v1ResourcesVersionsRetireCreate**
> ResourceVersion v1ResourcesVersionsRetireCreate(idempotencyKey, resourceId, versionId, resourceVersionRetire)



### Example
```java
// Import classes:
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.Configuration;
import com.x402api.client.core.auth.*;
import com.x402api.client.core.models.*;
import com.x402api.client.api.ResourcesAndPricingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.x402api.com");

    // Configure HTTP bearer authorization: tenantApiKey
    HttpBearerAuth tenantApiKey = (HttpBearerAuth) defaultClient.getAuthentication("tenantApiKey");
    tenantApiKey.setBearerToken("BEARER TOKEN");

    ResourcesAndPricingApi apiInstance = new ResourcesAndPricingApi(defaultClient);
    String idempotencyKey = "idempotencyKey_example"; // String | Unique mutation key; replaying different content returns HTTP 409.
    UUID resourceId = UUID.randomUUID(); // UUID |
    UUID versionId = UUID.randomUUID(); // UUID |
    ResourceVersionRetire resourceVersionRetire = new ResourceVersionRetire(); // ResourceVersionRetire |
    try {
      ResourceVersion result = apiInstance.v1ResourcesVersionsRetireCreate(idempotencyKey, resourceId, versionId, resourceVersionRetire);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesAndPricingApi#v1ResourcesVersionsRetireCreate");
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
| **resourceId** | **UUID**|  | |
| **versionId** | **UUID**|  | |
| **resourceVersionRetire** | [**ResourceVersionRetire**](ResourceVersionRetire.md)|  | |

### Return type

[**ResourceVersion**](ResourceVersion.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **409** |  |  -  |
