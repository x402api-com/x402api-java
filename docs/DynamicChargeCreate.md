

# DynamicChargeCreate


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**resourceVersionId** | **UUID** |  |  |
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
