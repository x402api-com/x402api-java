

# DynamicChargeCreate


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**resourceVersionId** | **UUID** | Current active resource-version UUID used as the charge template. Read resources[].active_version.id from GET /v1/resources or copy Active version UUID (charge API) in the tenant dashboard. Do not use the top-level resource id or pay_ public_payment_id. |  |
|**method** | **HTTPMethodEnum** |  |  [optional] |
|**resourceUrl** | **URI** |  |  |
|**bodyBase64** | **String** |  |  [optional] |
|**contentType** | **String** |  |  [optional] |
|**description** | **String** |  |  [optional] |
|**prices** | [**List&lt;DynamicChargePrice&gt;**](DynamicChargePrice.md) |  |  |
|**feeMode** | **FeePolicyModeInputEnum** |  |  [optional] |
|**quoteCurrency** | **FeePolicyQuoteCurrencyInputEnum** |  |  [optional] |
|**feeAllowanceCapQuoteMicros** | **String** |  |  [optional] |
|**expiresInSeconds** | **Integer** |  |  |
|**metadata** | **Map&lt;String, Object&gt;** | Tenant application metadata frozen into the charge digest. Maximum canonical size is 16 KiB; floating-point numbers are not accepted. |  [optional] |
