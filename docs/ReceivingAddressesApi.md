# ReceivingAddressesApi

All URIs are relative to *https://api.x402api.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**v1ReceivingAddressControlCapabilitiesRetrieve**](ReceivingAddressesApi.md#v1ReceivingAddressControlCapabilitiesRetrieve) | **GET** /v1/receiving-address-control-capabilities |  |
| [**v1ReceivingAddressControlChallengesCreate**](ReceivingAddressesApi.md#v1ReceivingAddressControlChallengesCreate) | **POST** /v1/receiving-address-control-challenges |  |
| [**v1ReceivingAddressesActivateCreate**](ReceivingAddressesApi.md#v1ReceivingAddressesActivateCreate) | **POST** /v1/receiving-addresses/{readiness_id}/activate |  |
| [**v1ReceivingAddressesCreate**](ReceivingAddressesApi.md#v1ReceivingAddressesCreate) | **POST** /v1/receiving-addresses |  |
| [**v1ReceivingAddressesList**](ReceivingAddressesApi.md#v1ReceivingAddressesList) | **GET** /v1/receiving-addresses |  |
| [**v1ReceivingAddressesReadinessRefreshesCreate**](ReceivingAddressesApi.md#v1ReceivingAddressesReadinessRefreshesCreate) | **POST** /v1/receiving-addresses/{readiness_id}/readiness-refreshes |  |
| [**v1ReceivingAddressesRotationsCreate**](ReceivingAddressesApi.md#v1ReceivingAddressesRotationsCreate) | **POST** /v1/receiving-addresses/{readiness_id}/rotations |  |


<a id="v1ReceivingAddressControlCapabilitiesRetrieve"></a>
# **v1ReceivingAddressControlCapabilitiesRetrieve**
> ExternalAddressControlCapabilities v1ReceivingAddressControlCapabilitiesRetrieve()



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
      ExternalAddressControlCapabilities result = apiInstance.v1ReceivingAddressControlCapabilitiesRetrieve();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReceivingAddressesApi#v1ReceivingAddressControlCapabilitiesRetrieve");
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
| **200** |  |  -  |

<a id="v1ReceivingAddressControlChallengesCreate"></a>
# **v1ReceivingAddressControlChallengesCreate**
> ExternalAddressControlChallenge v1ReceivingAddressControlChallengesCreate(idempotencyKey, externalAddressControlChallengeCreate)



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
    String idempotencyKey = "idempotencyKey_example"; // String | Unique mutation key; replaying different content returns HTTP 409.
    ExternalAddressControlChallengeCreate externalAddressControlChallengeCreate = new ExternalAddressControlChallengeCreate(); // ExternalAddressControlChallengeCreate |
    try {
      ExternalAddressControlChallenge result = apiInstance.v1ReceivingAddressControlChallengesCreate(idempotencyKey, externalAddressControlChallengeCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReceivingAddressesApi#v1ReceivingAddressControlChallengesCreate");
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
| **externalAddressControlChallengeCreate** | [**ExternalAddressControlChallengeCreate**](ExternalAddressControlChallengeCreate.md)|  | |

### Return type

[**ExternalAddressControlChallenge**](ExternalAddressControlChallenge.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  -  |

<a id="v1ReceivingAddressesActivateCreate"></a>
# **v1ReceivingAddressesActivateCreate**
> ExternalReceivingAddress v1ReceivingAddressesActivateCreate(idempotencyKey, readinessId)



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
    String idempotencyKey = "idempotencyKey_example"; // String | Unique mutation key; replaying different content returns HTTP 409.
    UUID readinessId = UUID.randomUUID(); // UUID |
    try {
      ExternalReceivingAddress result = apiInstance.v1ReceivingAddressesActivateCreate(idempotencyKey, readinessId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReceivingAddressesApi#v1ReceivingAddressesActivateCreate");
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
| **readinessId** | **UUID**|  | |

### Return type

[**ExternalReceivingAddress**](ExternalReceivingAddress.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |

<a id="v1ReceivingAddressesCreate"></a>
# **v1ReceivingAddressesCreate**
> ExternalReceivingAddress v1ReceivingAddressesCreate(idempotencyKey, externalReceivingAddressCreate)



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
    String idempotencyKey = "idempotencyKey_example"; // String | Unique mutation key; replaying different content returns HTTP 409.
    ExternalReceivingAddressCreate externalReceivingAddressCreate = new ExternalReceivingAddressCreate(); // ExternalReceivingAddressCreate |
    try {
      ExternalReceivingAddress result = apiInstance.v1ReceivingAddressesCreate(idempotencyKey, externalReceivingAddressCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReceivingAddressesApi#v1ReceivingAddressesCreate");
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
| **externalReceivingAddressCreate** | [**ExternalReceivingAddressCreate**](ExternalReceivingAddressCreate.md)|  | |

### Return type

[**ExternalReceivingAddress**](ExternalReceivingAddress.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  -  |

<a id="v1ReceivingAddressesList"></a>
# **v1ReceivingAddressesList**
> List&lt;ExternalReceivingAddress&gt; v1ReceivingAddressesList(cursor, pageSize)



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
      List<ExternalReceivingAddress> result = apiInstance.v1ReceivingAddressesList(cursor, pageSize);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReceivingAddressesApi#v1ReceivingAddressesList");
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
| **200** |  |  -  |

<a id="v1ReceivingAddressesReadinessRefreshesCreate"></a>
# **v1ReceivingAddressesReadinessRefreshesCreate**
> ExternalReceivingAddress v1ReceivingAddressesReadinessRefreshesCreate(idempotencyKey, readinessId)



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
    String idempotencyKey = "idempotencyKey_example"; // String | Unique mutation key; replaying different content returns HTTP 409.
    UUID readinessId = UUID.randomUUID(); // UUID |
    try {
      ExternalReceivingAddress result = apiInstance.v1ReceivingAddressesReadinessRefreshesCreate(idempotencyKey, readinessId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReceivingAddressesApi#v1ReceivingAddressesReadinessRefreshesCreate");
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
| **readinessId** | **UUID**|  | |

### Return type

[**ExternalReceivingAddress**](ExternalReceivingAddress.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **201** |  |  -  |

<a id="v1ReceivingAddressesRotationsCreate"></a>
# **v1ReceivingAddressesRotationsCreate**
> ExternalReceivingAddress v1ReceivingAddressesRotationsCreate(idempotencyKey, readinessId, externalReceivingAddressRotation)



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
    String idempotencyKey = "idempotencyKey_example"; // String | Unique mutation key; replaying different content returns HTTP 409.
    UUID readinessId = UUID.randomUUID(); // UUID |
    ExternalReceivingAddressRotation externalReceivingAddressRotation = new ExternalReceivingAddressRotation(); // ExternalReceivingAddressRotation |
    try {
      ExternalReceivingAddress result = apiInstance.v1ReceivingAddressesRotationsCreate(idempotencyKey, readinessId, externalReceivingAddressRotation);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReceivingAddressesApi#v1ReceivingAddressesRotationsCreate");
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
| **readinessId** | **UUID**|  | |
| **externalReceivingAddressRotation** | [**ExternalReceivingAddressRotation**](ExternalReceivingAddressRotation.md)|  | |

### Return type

[**ExternalReceivingAddress**](ExternalReceivingAddress.md)

### Authorization

[tenantApiKey](../README.md#tenantApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  -  |
