

# WalletBalanceResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**walletId** | **UUID** |  |  |
|**network** | **String** |  |  |
|**walletAddress** | **String** |  |  |
|**requestedFinality** | **WalletObservationFinalityEnum** |  |  |
|**observationState** | **ObservationStateEnum** |  |  |
|**observedAt** | **OffsetDateTime** |  |  |
|**assets** | [**List&lt;BalanceAsset&gt;**](BalanceAsset.md) |  |  |
|**walletVersions** | [**List&lt;WalletVersionBalance&gt;**](WalletVersionBalance.md) |  |  |
|**reseedContexts** | [**List&lt;WalletFencedChainReseedContext&gt;**](WalletFencedChainReseedContext.md) |  |  |
