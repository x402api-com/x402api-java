

# PaymentReceipt


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** |  |  [readonly] |
|**orderId** | **UUID** |  |  [readonly] |
|**settlementJobId** | **UUID** |  |  [readonly] |
|**receipt** | **Object** |  |  [readonly] |
|**receiptDigest** | **String** |  |  [readonly] |
|**signature** | **String** |  |  [readonly] |
|**signingKeyVersion** | **String** |  |  [readonly] |
|**eligibleAlternatives** | [**List&lt;PublicNetworkFeeAlternative&gt;**](PublicNetworkFeeAlternative.md) |  |  [readonly] |
|**feePolicy** | [**PublicFeePolicyDocument**](PublicFeePolicyDocument.md) |  |  [readonly] |
|**feeEvidence** | **Map&lt;String, Object&gt;** |  |  [readonly] |
|**feeQuoteDigest** | **String** |  |  [readonly] |
|**feeQuoteExpiresAt** | **OffsetDateTime** |  |  [readonly] |
|**settlementAmountAtomic** | **String** |  |  [readonly] |
|**gasMode** | **String** |  |  [readonly] |
|**buyerNativeFeeAtomic** | **String** |  |  [readonly] |
|**sponsoredNativeFeeAtomic** | **String** |  |  [readonly] |
|**sponsoredNativeSymbol** | **String** |  |  [readonly] |
|**tenantGasChargeMicros** | **String** |  |  [readonly] |
|**gasSponsorshipEvidenceDigest** | **String** |  |  [readonly] |
|**createdAt** | **OffsetDateTime** |  |  [readonly] |
