

# DynamicChargeResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chargeId** | **UUID** | Immutable challenge UUID created for this charge. |  |
|**chargeDigest** | **String** |  |  |
|**orderId** | **UUID** |  |  |
|**status** | **String** | Current projected order status; payment terms remain immutable. |  |
|**resourceVersionId** | **UUID** |  |  |
|**paymentIdentifier** | **String** | Opaque server challenge handle. Return it to the buyer as X-X402API-Challenge-Handle; it is not the buyer payment identifier. |  |
|**expiresAt** | **OffsetDateTime** |  |  |
|**createdAt** | **OffsetDateTime** |  |  |
|**prices** | [**List&lt;DynamicChargePrice&gt;**](DynamicChargePrice.md) |  |  |
|**requestedExpiresInSeconds** | **Integer** |  |  |
|**metadata** | **Map&lt;String, Object&gt;** | Tenant application metadata frozen into the charge digest. Maximum canonical size is 16 KiB; floating-point numbers are not accepted. |  |
|**metadataDigest** | **String** |  |  |
|**paymentRequired** | **Object** | Complete immutable x402 v2 PAYMENT-REQUIRED document. |  |
|**paymentRequiredHeader** | **String** | Canonical base64-encoded value to return in the buyer-facing PAYMENT-REQUIRED header. |  |
|**eligibleAlternatives** | [**List&lt;PublicNetworkFeeAlternative&gt;**](PublicNetworkFeeAlternative.md) |  |  |
|**feePolicy** | [**PublicFeePolicyDocument**](PublicFeePolicyDocument.md) |  |  |
|**feeQuoteDigest** | **String** |  |  |
