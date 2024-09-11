package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.trainingsale.domain.eventpublisher.EventPublisher;
import com.smalaca.trainingsale.domain.payment.PaymentRequest;
import com.smalaca.trainingsale.domain.payment.PaymentService;
import com.smalaca.trainingsale.domain.payment.PaymentStatus;
import com.smalaca.trainingsale.domain.trainingoffer.events.ResignedFromTrainingEvent;

import java.util.UUID;

@AggregateRoot
public class TrainingOffer {
    private final UUID trainingOfferId;
    private final Price price;
    private final TrainingGroup trainingGroup;
    private final ReservationList reservationList;
    private boolean isFinalized;

    TrainingOffer(UUID trainingOfferId, Price price, ReservationList reservationList, TrainingGroup trainingGroup) {
        this.trainingOfferId = trainingOfferId;
        this.price = price;
        this.reservationList = reservationList;
        this.trainingGroup = trainingGroup;
    }

    @PrimaryPort
    public void choose(Participant participant) {
        if (isOfferOpen()) {
            if (trainingGroup.hasAvailablePlaces()) {
                trainingGroup.book(participant);
            } else if (reservationList.hasAvailablePlaces()) {
                reservationList.add(participant);
            } else {
                throw new NoAvailablePlacesLeftException(trainingOfferId);
            }
        } else {
            throw new ClosedTrainingOfferException(trainingOfferId);
        }
    }

    @PrimaryPort
    public void buy(Participant participant, PaymentMethod paymentMethod, PaymentService paymentService) {
        if (isOfferOpen()) {
            PaymentStatus status = paymentService.pay(asPayment(participant, paymentMethod));

            if (status.successful()) {
                trainingGroup.confirm(participant);
            } else {
                trainingGroup.resign(participant);
            }
        } else {
            throw new ClosedTrainingOfferException(trainingOfferId);
        }
    }

    private PaymentRequest asPayment(Participant participant, PaymentMethod paymentMethod) {
        return new PaymentRequest(
                paymentMethod.name(),
                trainingOfferId,
                participant.firstName(),
                participant.lastName(),
                price.value()
        );
    }

    @PrimaryPort
    public void cancelReservation(Participant participant) {
        trainingGroup.cancelBooking(participant);
    }

    @PrimaryPort
    public void resign(Participant participant, EventPublisher eventPublisher) {
        trainingGroup.resign(participant);

        ResignedFromTrainingEvent event = new ResignedFromTrainingEvent(trainingOfferId, participant.firstName(), participant.lastName());
        eventPublisher.publish(event);
    }

    @PrimaryPort
    public void start() {
        if (!isOfferOpen()) {
            isFinalized = true;
        }
    }

    private boolean isOfferOpen() {
        return false;
    }
}
