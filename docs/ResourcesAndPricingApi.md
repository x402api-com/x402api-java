# ResourcesAndPricingApi

All URIs are relative to *https://api.x402api.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**networkFeesCreateQuote**](ResourcesAndPricingApi.md#networkFeesCreateQuote) | **POST** /v1/network-fee-quotes | Create a network-fee quote |
| [**resourcesActivateVersion**](ResourcesAndPricingApi.md#resourcesActivateVersion) | **POST** /v1/resources/{resource_id}/versions/{version_id}/activate | Activate a resource version |
| [**resourcesCreate**](ResourcesAndPricingApi.md#resourcesCreate) | **POST** /v1/resources | Create a resource |
| [**resourcesCreateVersion**](ResourcesAndPricingApi.md#resourcesCreateVersion) | **POST** /v1/resources/{resource_id}/versions | Create a resource version |
| [**resourcesList**](ResourcesAndPricingApi.md#resourcesList) | **GET** /v1/resources | List resources |
| [**resourcesListVersions**](ResourcesAndPricingApi.md#resourcesListVersions) | **GET** /v1/resources/{resource_id}/versions | List resource versions |
| [**resourcesRetireVersion**](ResourcesAndPricingApi.md#resourcesRetireVersion) | **POST** /v1/resources/{resource_id}/versions/{version_id}/retire | Retire a resource version |


<a id="networkFeesCreateQuote"></a>
# **networkFeesCreateQuote**
> NetworkFeePreviewResponse networkFeesCreateQuote(networkFeePreview)

Create a network-fee quote

Preview bounded network fees for the requested resource prices and rails.

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
      NetworkFeePreviewResponse result = apiInstance.networkFeesCreateQuote(networkFeePreview);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesAndPricingApi#networkFeesCreateQuote");
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
| **200** | Successful response for create a network-fee quote. |  * X-Request-ID -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |

<a id="resourcesActivateVersion"></a>
# **resourcesActivateVersion**
> ResourceVersion resourcesActivateVersion(idempotencyKey, resourceId, versionId, resourceVersionActivate)

Activate a resource version

Activate one immutable resource version idempotently.

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
    String idempotencyKey = "idempotencyKey_example"; // String | Caller-persisted mutation key containing 8 to 160 safe ASCII characters. Replay the exact key and body after an uncertain outcome.
    UUID resourceId = UUID.randomUUID(); // UUID |
    UUID versionId = UUID.randomUUID(); // UUID |
    ResourceVersionActivate resourceVersionActivate = new ResourceVersionActivate(); // ResourceVersionActivate |
    try {
      ResourceVersion result = apiInstance.resourcesActivateVersion(idempotencyKey, resourceId, versionId, resourceVersionActivate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesAndPricingApi#resourcesActivateVersion");
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
| **200** | Successful response for activate a resource version. |  * X-Request-ID -  <br>  |
| **409** | The request failed. |  * X-Request-ID -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |

<a id="resourcesCreate"></a>
# **resourcesCreate**
> Resource resourcesCreate(idempotencyKey, resourceCreate)

Create a resource

Create one tenant resource idempotently.

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
    String idempotencyKey = "idempotencyKey_example"; // String | Caller-persisted mutation key containing 8 to 160 safe ASCII characters. Replay the exact key and body after an uncertain outcome.
    ResourceCreate resourceCreate = new ResourceCreate(); // ResourceCreate |
    try {
      Resource result = apiInstance.resourcesCreate(idempotencyKey, resourceCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesAndPricingApi#resourcesCreate");
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
| **201** | Successful response for create a resource. |  * X-Request-ID -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |

<a id="resourcesCreateVersion"></a>
# **resourcesCreateVersion**
> ResourceVersion resourcesCreateVersion(idempotencyKey, resourceId, resourceVersionCreate)

Create a resource version

Create an immutable priced version of one tenant resource idempotently.

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
    String idempotencyKey = "idempotencyKey_example"; // String | Caller-persisted mutation key containing 8 to 160 safe ASCII characters. Replay the exact key and body after an uncertain outcome.
    UUID resourceId = UUID.randomUUID(); // UUID |
    ResourceVersionCreate resourceVersionCreate = new ResourceVersionCreate(); // ResourceVersionCreate |
    try {
      ResourceVersion result = apiInstance.resourcesCreateVersion(idempotencyKey, resourceId, resourceVersionCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesAndPricingApi#resourcesCreateVersion");
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
| **201** | Successful response for create a resource version. |  * X-Request-ID -  <br>  |
| **409** | The request failed. |  * X-Request-ID -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |

<a id="resourcesList"></a>
# **resourcesList**
> List&lt;Resource&gt; resourcesList(cursor, pageSize)

List resources

List tenant resources and their visible versions using opaque cursor pagination.

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
      List<Resource> result = apiInstance.resourcesList(cursor, pageSize);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesAndPricingApi#resourcesList");
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
| **200** | Successful response for list resources. |  * X-Request-ID -  <br>  * Link -  <br>  * X-X402API-Next-Cursor -  <br>  * X-X402API-Result-Truncated -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |

<a id="resourcesListVersions"></a>
# **resourcesListVersions**
> List&lt;ResourceVersion&gt; resourcesListVersions(resourceId, cursor, pageSize)

List resource versions

List immutable versions of one tenant resource using opaque cursor pagination.

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
      List<ResourceVersion> result = apiInstance.resourcesListVersions(resourceId, cursor, pageSize);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesAndPricingApi#resourcesListVersions");
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
| **200** | Successful response for list resource versions. |  * X-Request-ID -  <br>  * Link -  <br>  * X-X402API-Next-Cursor -  <br>  * X-X402API-Result-Truncated -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |

<a id="resourcesRetireVersion"></a>
# **resourcesRetireVersion**
> ResourceVersion resourcesRetireVersion(idempotencyKey, resourceId, versionId, resourceVersionRetire)

Retire a resource version

Retire one immutable resource version idempotently.

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
    String idempotencyKey = "idempotencyKey_example"; // String | Caller-persisted mutation key containing 8 to 160 safe ASCII characters. Replay the exact key and body after an uncertain outcome.
    UUID resourceId = UUID.randomUUID(); // UUID |
    UUID versionId = UUID.randomUUID(); // UUID |
    ResourceVersionRetire resourceVersionRetire = new ResourceVersionRetire(); // ResourceVersionRetire |
    try {
      ResourceVersion result = apiInstance.resourcesRetireVersion(idempotencyKey, resourceId, versionId, resourceVersionRetire);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesAndPricingApi#resourcesRetireVersion");
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
| **200** | Successful response for retire a resource version. |  * X-Request-ID -  <br>  |
| **409** | The request failed. |  * X-Request-ID -  <br>  |
| **0** | The request failed with a stable machine-readable error. |  * X-Request-ID -  <br>  * Retry-After -  <br>  |
