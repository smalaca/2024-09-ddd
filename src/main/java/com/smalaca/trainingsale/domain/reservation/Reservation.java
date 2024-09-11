package com.smalaca.trainingsale.domain.reservation;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.trainingsale.domain.eventpublisher.EventPublisher;
import com.smalaca.trainingsale.domain.participant.Participant;
import com.smalaca.trainingsale.domain.payment.PaymentDto;
import com.smalaca.trainingsale.domain.payment.PaymentService;
import com.smalaca.trainingsale.domain.payment.PaymentStatus;
import com.smalaca.trainingsale.domain.price.Price;
import com.smalaca.trainingsale.domain.reservation.events.TrainingOfferPaidEvent;

import java.util.UUID;

@AggregateRoot
public class Reservation {
    private final UUID trainingOfferId;
    private final Price price;
    private final Participant participant;

    public Reservation(UUID trainingOfferId, Price price, Participant participant) {
        this.trainingOfferId = trainingOfferId;
        this.price = price;
        this.participant = participant;
    }

    @PrimaryPort
    public void buy(PaymentMethod paymentMethod, PaymentService paymentService, EventPublisher eventPublisher) {
        if (isNoLongerAvailable()) {
            throw new NoAvailableReservationException(trainingOfferId);
        }

        PaymentStatus status = paymentService.pay(asPayment(paymentMethod));

        if (status.successful()) {
            eventPublisher.publish(new TrainingOfferPaidEvent(trainingOfferId, participant.firstName(), participant.lastName()));
        }
    }

    private boolean isNoLongerAvailable() {
        return false;
    }

    private PaymentDto asPayment(PaymentMethod paymentMethod) {
        return new PaymentDto(
                paymentMethod.name(),
                trainingOfferId,
                participant.firstName(),
                participant.lastName(),
                price.value());
    }
}
