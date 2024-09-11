package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;

import java.util.UUID;

@AggregateRoot
public class TrainingOffer {
    private final UUID trainingOfferId;
    private final TrainingGroup trainingGroup;
    private final ReservationList reservationList;
    private boolean isFinalized;

    TrainingOffer(UUID trainingOfferId, ReservationList reservationList, TrainingGroup trainingGroup) {
        this.trainingOfferId = trainingOfferId;
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
            }
        } else {
            throw new ClosedTrainingOfferException(trainingOfferId);
        }
    }

    @PrimaryPort
    public void buy(Participant participant, PaymentMethod paymentMethod) {
        trainingGroup.confirm(participant);
    }

    @PrimaryPort
    public void cancelReservation(Participant participant) {
        trainingGroup.cancelBooking(participant);
    }

    @PrimaryPort
    public void resign(Participant participant) {
        trainingGroup.resign(participant);
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
