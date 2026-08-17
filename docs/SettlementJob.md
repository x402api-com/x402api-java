

# SettlementJob


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** |  |  [readonly] |
|**orderId** | **UUID** |  |  [readonly] |
|**reservationId** | **UUID** |  |  [readonly] |
|**state** | **SettlementJobStateEnum** |  |  [readonly] |
|**network** | **String** |  |  [readonly] |
|**transactionHash** | **String** |  |  [readonly] |
|**originalTransactionHash** | **String** |  |  [readonly] |
|**replacedByHash** | **String** |  |  [readonly] |
|**gasExecutionState** | **String** |  |  [readonly] |
|**gasExecutionSequence** | **Integer** |  |  [readonly] |
|**gasExecutionMaterialDigest** | **String** |  |  [readonly] |
|**gasExecutionObservedAt** | **OffsetDateTime** |  |  [readonly] |
|**payer** | **String** |  |  [readonly] |
|**lastErrorCode** | **String** |  |  [readonly] |
|**broadcastAttemptCount** | **Integer** |  |  [readonly] |
|**settlementResult** | **Object** |  |  [readonly] |
|**confirmedAt** | **OffsetDateTime** |  |  [readonly] |
|**finalizedAt** | **OffsetDateTime** |  |  [readonly] |
|**createdAt** | **OffsetDateTime** |  |  [readonly] |
|**updatedAt** | **OffsetDateTime** |  |  [readonly] |
|**order** | [**TenantPaymentOrderProjection**](TenantPaymentOrderProjection.md) |  |  [readonly] |
|**resource** | [**TenantPaymentResourceProjection**](TenantPaymentResourceProjection.md) |  |  [readonly] |
|**asset** | [**TenantPaymentAssetProjection**](TenantPaymentAssetProjection.md) |  |  [readonly] |
|**chain** | [**TenantPaymentChainProjection**](TenantPaymentChainProjection.md) |  |  [readonly] |
|**receipt** | [**TenantPaymentReceiptProjection**](TenantPaymentReceiptProjection.md) |  |  [readonly] |
|**screening** | [**TenantPaymentScreeningProjection**](TenantPaymentScreeningProjection.md) |  |  [readonly] |
|**fulfillment** | [**TenantPaymentFulfillmentProjection**](TenantPaymentFulfillmentProjection.md) |  |  [readonly] |
