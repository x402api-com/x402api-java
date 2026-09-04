package com.x402api.client.api;

import com.x402api.client.model.PaymentReceipt;
import com.x402api.client.model.PaymentReceiptStatus;
import java.util.List;
import java.util.Map;

/** A status-aware result from the payment receipt endpoint. */
public final class PaymentReceiptOutcome {
    private final int statusCode;
    private final Map<String, List<String>> headers;
    private final PaymentReceipt receipt;
    private final PaymentReceiptStatus pendingStatus;

    private PaymentReceiptOutcome(
            int statusCode,
            Map<String, List<String>> headers,
            PaymentReceipt receipt,
            PaymentReceiptStatus pendingStatus) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.receipt = receipt;
        this.pendingStatus = pendingStatus;
    }

    static PaymentReceiptOutcome finalized(
            Map<String, List<String>> headers, PaymentReceipt receipt) {
        return new PaymentReceiptOutcome(200, headers, receipt, null);
    }

    static PaymentReceiptOutcome pending(
            Map<String, List<String>> headers, PaymentReceiptStatus pendingStatus) {
        return new PaymentReceiptOutcome(202, headers, null, pendingStatus);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public boolean isFinalized() {
        return receipt != null;
    }

    public boolean isPending() {
        return pendingStatus != null;
    }

    @javax.annotation.Nullable
    public PaymentReceipt getReceipt() {
        return receipt;
    }

    @javax.annotation.Nullable
    public PaymentReceiptStatus getPendingStatus() {
        return pendingStatus;
    }

    public boolean isConfirmed() {
        return receipt != null || Boolean.TRUE.equals(pendingStatus.getConfirmed());
    }
}
