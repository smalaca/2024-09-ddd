package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;

import java.util.UUID;

@AggregateRoot
public class TrainingOffer {
    private final UUID trainingOfferId;
    private final ReservationList reservationList;
    private final TrainingGroup trainingGroup;
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
                reservationList.add(participant);
            }
        } else {
            throw new ClosedTrainingOfferException(trainingOfferId);
        }
    }

    @PrimaryPort
    public void buy(Participant participant, PaymentMethod paymentMethod) {
        reservationList.remove(participant);
        trainingGroup.add(participant);
    }

    @PrimaryPort
    public void cancelReservation(Participant participant) {
        reservationList.remove(participant);
    }

    @PrimaryPort
    public void resign(Participant participant) {
        trainingGroup.remove(participant);
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
