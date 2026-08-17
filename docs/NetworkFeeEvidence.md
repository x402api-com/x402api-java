

# NetworkFeeEvidence

Published shape for available and explicitly unavailable fee evidence.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **String** |  |  |
|**version** | **Integer** |  |  |
|**network** | **String** |  |  |
|**assetId** | **String** |  |  |
|**payloadProfile** | **String** |  |  |
|**nativeSymbol** | **String** |  |  [optional] |
|**nativeDecimals** | **Integer** |  |  [optional] |
|**nativeFeeObservations** | [**List&lt;NativeFeeObservationEvidence&gt;**](NativeFeeObservationEvidence.md) |  |  [optional] |
|**nativeUsdObservations** | [**List&lt;NativeUsdObservationEvidence&gt;**](NativeUsdObservationEvidence.md) |  |  [optional] |
|**expiresAt** | **OffsetDateTime** |  |  [optional] |
