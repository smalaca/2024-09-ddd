package com.smalaca.trainingsale.domain.payment;

import com.smalaca.annotation.architecture.SecondaryPort;

@SecondaryPort
public interface PaymentService {
    PaymentStatus pay(PaymentRequest paymentDto);
}
