

# DynamicChargeResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chargeId** | **UUID** |  |  |
|**chargeDigest** | **String** |  |  |
|**orderId** | **UUID** |  |  |
|**status** | **String** |  |  |
|**resourceVersionId** | **UUID** |  |  |
|**paymentIdentifier** | **String** |  |  |
|**expiresAt** | **OffsetDateTime** |  |  |
|**createdAt** | **OffsetDateTime** |  |  |
|**prices** | [**List&lt;DynamicChargePrice&gt;**](DynamicChargePrice.md) |  |  |
|**requestedExpiresInSeconds** | **Integer** |  |  |
|**metadata** | **Map&lt;String, Object&gt;** | Tenant application metadata frozen into the charge digest. Maximum canonical size is 16 KiB; floating-point numbers are not accepted. |  |
|**metadataDigest** | **String** |  |  |
|**paymentRequired** | **Object** |  |  |
|**paymentRequiredHeader** | **String** |  |  |
|**eligibleAlternatives** | [**List&lt;NetworkFeeAlternative&gt;**](NetworkFeeAlternative.md) |  |  |
|**feePolicy** | [**FeePolicyDocument**](FeePolicyDocument.md) |  |  |
|**feeQuoteDigest** | **String** |  |  |
