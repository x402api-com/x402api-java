package com.x402api.client.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.x402api.client.core.ApiClient;
import com.x402api.client.core.ApiException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;

class StatusAwareOrdersAndPaymentsApiTest {
    private static final UUID PAYMENT_ID = UUID.fromString("11111111-1111-4111-8111-111111111111");

    @Test
    void returnsTypedPendingStatusFromOne202Request() throws Exception {
        AtomicInteger requests = new AtomicInteger();
        StatusAwareOrdersAndPaymentsApi api = apiReturning(202, pendingJson(PAYMENT_ID), requests);

        PaymentReceiptOutcome outcome = api.paymentsRetrieveReceipt(PAYMENT_ID);

        assertEquals(1, requests.get());
        assertEquals(202, outcome.getStatusCode());
        assertTrue(outcome.isPending());
        assertFalse(outcome.isFinalized());
        assertTrue(outcome.isConfirmed());
        assertEquals(PAYMENT_ID, outcome.getPendingStatus().getPaymentId());
    }

    @Test
    void returnsTypedFinalizedReceiptFromOne200Request() throws Exception {
        AtomicInteger requests = new AtomicInteger();
        StatusAwareOrdersAndPaymentsApi api =
                apiReturning(200, finalizedJson(PAYMENT_ID), requests);

        PaymentReceiptOutcome outcome = api.paymentsRetrieveReceipt(PAYMENT_ID);

        assertEquals(1, requests.get());
        assertEquals(200, outcome.getStatusCode());
        assertTrue(outcome.isFinalized());
        assertTrue(outcome.isConfirmed());
        assertNotNull(outcome.getReceipt());
    }

    @Test
    void rejects200ForAnotherPayment() {
        UUID anotherPayment = UUID.fromString("22222222-2222-4222-8222-222222222222");
        StatusAwareOrdersAndPaymentsApi api =
                apiReturning(200, finalizedJson(anotherPayment), new AtomicInteger());

        ApiException exception =
                assertThrows(ApiException.class, () -> api.paymentsRetrieveReceipt(PAYMENT_ID));

        assertEquals(200, exception.getCode());
    }

    @Test
    void rejects202ForAnotherPayment() {
        UUID anotherPayment = UUID.fromString("22222222-2222-4222-8222-222222222222");
        StatusAwareOrdersAndPaymentsApi api =
                apiReturning(202, pendingJson(anotherPayment), new AtomicInteger());

        ApiException exception =
                assertThrows(ApiException.class, () -> api.paymentsRetrieveReceipt(PAYMENT_ID));

        assertEquals(202, exception.getCode());
    }

    @Test
    void rejectsInconsistentPendingFinalityResponse() {
        String inconsistent =
                pendingJson(PAYMENT_ID).replace("\"confirmed\":true", "\"confirmed\":false");
        StatusAwareOrdersAndPaymentsApi api = apiReturning(202, inconsistent, new AtomicInteger());

        ApiException exception =
                assertThrows(ApiException.class, () -> api.paymentsRetrieveReceipt(PAYMENT_ID));

        assertEquals(202, exception.getCode());
    }

    @Test
    void rejectsConfirmedFlagWithPreConfirmationState() {
        String inconsistent =
                pendingJson(PAYMENT_ID)
                        .replace("\"state\":\"confirmed\"", "\"state\":\"confirming\"");
        StatusAwareOrdersAndPaymentsApi api = apiReturning(202, inconsistent, new AtomicInteger());

        ApiException exception =
                assertThrows(ApiException.class, () -> api.paymentsRetrieveReceipt(PAYMENT_ID));

        assertEquals(202, exception.getCode());
    }

    @Test
    void rejectsTerminalStateAsPendingConfirmation() {
        String terminal =
                pendingJson(PAYMENT_ID)
                        .replace("\"state\":\"confirmed\"", "\"state\":\"reorged\"")
                        .replace("\"confirmed\":true", "\"confirmed\":false")
                        .replace(
                                "\"receipt_status\":\"pending_finality\"",
                                "\"receipt_status\":\"pending_confirmation\"");
        StatusAwareOrdersAndPaymentsApi api = apiReturning(202, terminal, new AtomicInteger());

        ApiException exception =
                assertThrows(ApiException.class, () -> api.paymentsRetrieveReceipt(PAYMENT_ID));

        assertEquals(202, exception.getCode());
    }

    @Test
    void rejectsUnknownStateAsPendingConfirmation() {
        String unknown =
                pendingJson(PAYMENT_ID)
                        .replace("\"state\":\"confirmed\"", "\"state\":\"unknown_future_state\"")
                        .replace("\"confirmed\":true", "\"confirmed\":false")
                        .replace(
                                "\"receipt_status\":\"pending_finality\"",
                                "\"receipt_status\":\"pending_confirmation\"");
        StatusAwareOrdersAndPaymentsApi api = apiReturning(202, unknown, new AtomicInteger());

        ApiException exception =
                assertThrows(ApiException.class, () -> api.paymentsRetrieveReceipt(PAYMENT_ID));

        assertEquals(202, exception.getCode());
    }

    private static StatusAwareOrdersAndPaymentsApi apiReturning(
            int statusCode, String body, AtomicInteger requests) {
        Interceptor responseInterceptor =
                chain -> {
                    requests.incrementAndGet();
                    return new Response.Builder()
                            .request(chain.request())
                            .protocol(Protocol.HTTP_1_1)
                            .code(statusCode)
                            .message("test response")
                            .header("Content-Type", "application/json")
                            .header("Retry-After", "2")
                            .body(ResponseBody.create(body, MediaType.get("application/json")))
                            .build();
                };
        ApiClient client =
                new ApiClient(
                                new OkHttpClient.Builder()
                                        .addInterceptor(responseInterceptor)
                                        .build())
                        .setBasePath("https://example.test");
        return new StatusAwareOrdersAndPaymentsApi(new OrdersAndPaymentsApi(client));
    }

    private static String pendingJson(UUID paymentId) {
        return "{"
                + "\"payment_id\":\""
                + paymentId
                + "\","
                + "\"state\":\"confirmed\","
                + "\"confirmed\":true,"
                + "\"finalized\":false,"
                + "\"confirmed_at\":\"2026-09-04T00:00:00Z\","
                + "\"finalized_at\":null,"
                + "\"transaction\":\"0xabc\","
                + "\"network\":\"eip155:8453\","
                + "\"receipt_status\":\"pending_finality\""
                + "}";
    }

    private static String finalizedJson(UUID paymentId) {
        return "{"
                + "\"id\":\"33333333-3333-4333-8333-333333333333\","
                + "\"order_id\":\"44444444-4444-4444-8444-444444444444\","
                + "\"settlement_job_id\":\""
                + paymentId
                + "\","
                + "\"receipt\":{},"
                + "\"receipt_digest\":\"sha256:test\","
                + "\"signature\":\"test-signature\","
                + "\"signing_key_version\":\"v1\","
                + "\"eligible_alternatives\":[],"
                + "\"fee_policy\":null,"
                + "\"fee_evidence\":null,"
                + "\"fee_quote_digest\":null,"
                + "\"fee_quote_expires_at\":null,"
                + "\"settlement_amount_atomic\":\"1\","
                + "\"gas_mode\":\"sponsored\","
                + "\"buyer_native_fee_atomic\":null,"
                + "\"sponsored_native_fee_atomic\":null,"
                + "\"sponsored_native_symbol\":null,"
                + "\"tenant_gas_charge_micros\":null,"
                + "\"gas_sponsorship_evidence_digest\":null,"
                + "\"created_at\":\"2026-09-04T00:00:00Z\""
                + "}";
    }
}
