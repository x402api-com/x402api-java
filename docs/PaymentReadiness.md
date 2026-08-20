

# PaymentReadiness


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**state** | **PaymentReadinessStateEnum** |  |  [readonly] |
|**acceptingNewPayments** | **Boolean** |  |  [readonly] |
|**pausedByTenant** | **Boolean** |  |  [readonly] |
|**platformAvailable** | **Boolean** |  |  [readonly] |
|**healthValidUntil** | **OffsetDateTime** |  |  [readonly] |
|**observedAt** | **OffsetDateTime** |  |  [readonly] |
|**tenantStatus** | **String** |  |  [readonly] |
|**tenantAcceptingNewChallenges** | **Boolean** |  |  [readonly] |
|**globalChallengesEnabled** | **Boolean** |  |  [readonly] |
|**globalSettlementEnabled** | **Boolean** |  |  [readonly] |
|**controlPlaneReadyForNewChallenges** | **Boolean** |  |  [readonly] |
|**controlPlaneReadyForSettlement** | **Boolean** |  |  [readonly] |
|**externalOnboarding** | **Object** |  |  [readonly] |
|**rails** | [**List&lt;PaymentReadinessRail&gt;**](PaymentReadinessRail.md) |  |  [readonly] |
|**canonicalRails** | [**List&lt;CanonicalPaymentReadinessRail&gt;**](CanonicalPaymentReadinessRail.md) |  |  [readonly] |
