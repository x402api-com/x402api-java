package com.x402api.client.api;

import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import com.x402api.client.core.ApiResponse;
import com.x402api.client.model.PaymentReceipt;
import com.x402api.client.model.PaymentReceiptStatus;
import com.x402api.client.model.ReceiptStatusEnum;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/** Status-aware access to receipt responses that may be either HTTP 200 or HTTP 202. */
public final class StatusAwareOrdersAndPaymentsApi {
    private static final Type JSON_ELEMENT_TYPE = new TypeToken<JsonElement>() {}.getType();
    private static final Set<String> ACTIONABLE_PRE_CONFIRMATION_STATES =
            Collections.unmodifiableSet(
                    new HashSet<>(
                            Arrays.asList(
                                    "created",
                                    "verifying",
                                    "verified",
                                    "reserved",
                                    "broadcasting",
                                    "broadcast_unknown",
                                    "broadcast",
                                    "confirming")));

    private final OrdersAndPaymentsApi delegate;

    public StatusAwareOrdersAndPaymentsApi(OrdersAndPaymentsApi delegate) {
        this.delegate = Objects.requireNonNull(delegate, "delegate");
    }

    public PaymentReceiptOutcome paymentsRetrieveReceipt(UUID paymentId) throws ApiException {
        if (paymentId == null) {
            throw new ApiException("Missing the required parameter 'paymentId'");
        }

        ApiClient apiClient = delegate.getApiClient();
        ApiResponse<JsonElement> response =
                apiClient.execute(
                        delegate.paymentsRetrieveReceiptCall(paymentId, null), JSON_ELEMENT_TYPE);
        JsonElement body = response.getData();

        try {
            if (response.getStatusCode() == 200) {
                PaymentReceipt.validateJsonElement(body);
                PaymentReceipt receipt = PaymentReceipt.fromJson(body.toString());
                if (!paymentId.equals(receipt.getSettlementJobId())) {
                    throw new IllegalArgumentException(
                            "Receipt settlement_job_id does not match the request");
                }
                return PaymentReceiptOutcome.finalized(response.getHeaders(), receipt);
            }
            if (response.getStatusCode() == 202) {
                PaymentReceiptStatus.validateJsonElement(body);
                PaymentReceiptStatus status = PaymentReceiptStatus.fromJson(body.toString());
                validatePendingStatus(paymentId, status);
                return PaymentReceiptOutcome.pending(response.getHeaders(), status);
            }
        } catch (IOException | RuntimeException exception) {
            throw invalidResponse(response, body, exception);
        }

        throw invalidResponse(
                response,
                body,
                new IllegalArgumentException(
                        "Unexpected successful receipt response status "
                                + response.getStatusCode()));
    }

    private static void validatePendingStatus(UUID paymentId, PaymentReceiptStatus status) {
        if (!paymentId.equals(status.getPaymentId())) {
            throw new IllegalArgumentException(
                    "Receipt status payment_id does not match the request");
        }
        if (Boolean.TRUE.equals(status.getFinalized())) {
            throw new IllegalArgumentException("HTTP 202 receipt status cannot be finalized");
        }
        if (status.getTransaction().trim().isEmpty() || status.getNetwork().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Receipt status transaction and network must be non-empty");
        }

        ReceiptStatusEnum receiptStatus = status.getReceiptStatus();
        if (receiptStatus == ReceiptStatusEnum.UNKNOWN_DEFAULT_OPEN_API) {
            throw new IllegalArgumentException("Unknown receipt status is not actionable");
        }
        boolean confirmed = Boolean.TRUE.equals(status.getConfirmed());
        if (confirmed) {
            if (!"confirmed".equals(status.getState())
                    || receiptStatus != ReceiptStatusEnum.PENDING_FINALITY) {
                throw new IllegalArgumentException(
                        "Confirmed receipt status must have state confirmed and pending_finality");
            }
        } else if (!ACTIONABLE_PRE_CONFIRMATION_STATES.contains(status.getState())
                || receiptStatus != ReceiptStatusEnum.PENDING_CONFIRMATION) {
            throw new IllegalArgumentException(
                    "Unconfirmed receipt status must have a pre-confirmation state and"
                            + " pending_confirmation");
        }
    }

    private static ApiException invalidResponse(
            ApiResponse<JsonElement> response, JsonElement body, Exception cause) {
        Map<String, List<String>> headers = response.getHeaders();
        String responseBody = body == null ? null : body.toString();
        return new ApiException(
                "Invalid payment receipt response",
                cause,
                response.getStatusCode(),
                headers,
                responseBody);
    }
}
