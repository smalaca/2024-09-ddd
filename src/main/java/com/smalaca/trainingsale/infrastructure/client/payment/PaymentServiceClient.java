package com.smalaca.trainingsale.infrastructure.client.payment;

import com.smalaca.payment.application.payment.PaymentRequest;
import com.smalaca.payment.infrastructure.api.PaymentApi;
import com.smalaca.payment.infrastructure.api.PaymentResponse;
import com.smalaca.trainingsale.domain.payment.PaymentDto;
import com.smalaca.trainingsale.domain.payment.PaymentService;
import com.smalaca.trainingsale.domain.payment.PaymentStatus;
import org.springframework.stereotype.Service;

import static com.smalaca.payment.infrastructure.api.PaymentStatus.SUCCESS;

@Service
public class PaymentServiceClient implements PaymentService {
    private final PaymentApi paymentApi;
    private final String companyIdentifier;

    PaymentServiceClient(PaymentApi paymentApi, String companyIdentifier) {
        this.paymentApi = paymentApi;
        this.companyIdentifier = companyIdentifier;
    }

    @Override
    public PaymentStatus pay(PaymentDto paymentDto) {
        PaymentRequest request = asPaymentRequest(paymentDto);
        PaymentResponse response = paymentApi.pay(request);

        return asPaymentStatus(response);
    }

    private PaymentStatus asPaymentStatus(PaymentResponse response) {
        return new PaymentStatus(isSuccessful(response));
    }

    private boolean isSuccessful(PaymentResponse response) {
        return SUCCESS.equals(response.status());
    }

    private PaymentRequest asPaymentRequest(PaymentDto dto) {
        return new PaymentRequest(
                dto.firstName() + " " + dto.lastName(),
                companyIdentifier,
                dto.price(),
                "Payment for participating: " + dto.trainingOfferId()
        );
    }
}
