package com.smalaca.payment.infrastructure.api;

import com.smalaca.payment.application.payment.PaymentApplicationService;
import com.smalaca.payment.application.payment.PaymentRequest;
import com.smalaca.payment.domain.payment.PaymentException;
import org.springframework.stereotype.Component;

@Component
public class PaymentApi {
    private final PaymentApplicationService paymentApplicationService;

    PaymentApi(PaymentApplicationService paymentApplicationService) {
        this.paymentApplicationService = paymentApplicationService;
    }

    public PaymentResponse pay(PaymentRequest request) {
        try {
            paymentApplicationService.pay(request);
            return PaymentResponse.success();
        } catch (PaymentException exception) {
            return PaymentResponse.failure(exception.getMessage());
        } catch (RuntimeException exception) {
            return PaymentResponse.error(exception.getMessage());
        }
    }
}
