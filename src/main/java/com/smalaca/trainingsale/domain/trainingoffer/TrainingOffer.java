package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;

@AggregateRoot
public class TrainingOffer {
    private final ReservationList reservationList = new ReservationList();
    private final TrainingGroup trainingGroup = new TrainingGroup();
    private boolean isFinalized;

    @PrimaryPort
    public void choose(Participant participant) {
        reservationList.add(participant);
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
        isFinalized = true;
    }
}
