package com.smalaca.trainingsale.application.reservation;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.trainingsale.domain.eventpublisher.EventPublisher;
import com.smalaca.trainingsale.domain.payment.PaymentService;
import com.smalaca.trainingsale.domain.reservation.Reservation;
import com.smalaca.trainingsale.domain.reservation.ReservationRepository;
import com.smalaca.trainingsale.domain.reservation.PaymentMethod;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReservationApplicationService {
    private final ReservationRepository reservationRepository;
    private final PaymentService paymentService;
    private final EventPublisher eventPublisher;

    ReservationApplicationService(
            ReservationRepository reservationRepository, PaymentService paymentService, EventPublisher eventPublisher) {
        this.reservationRepository = reservationRepository;
        this.paymentService = paymentService;
        this.eventPublisher = eventPublisher;
    }

    @PrimaryAdapter
    public void buy(UUID reservationId, String paymentMethod) {
        Reservation reservation = reservationRepository.findById(reservationId);
        PaymentMethod paymentMethodVO = PaymentMethod.of(paymentMethod);

        reservation.buy(paymentMethodVO, paymentService, eventPublisher);
    }
}
