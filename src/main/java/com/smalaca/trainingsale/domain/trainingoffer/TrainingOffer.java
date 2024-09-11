package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;

import java.util.ArrayList;
import java.util.List;

@AggregateRoot
public class TrainingOffer {
    private final List<Participant> reservations = new ArrayList<>();
    private final List<Participant> participants = new ArrayList<>();
    private boolean isFinalized;

    @PrimaryPort
    public void choose(Participant participant) {
        reservations.add(participant);
    }

    @PrimaryPort
    public void buy(Participant participant, PaymentMethod paymentMethod) {
        Participant existing = findReservation(participant);

        reservations.remove(existing);
        participants.add(existing);
    }

    @PrimaryPort
    public void cancelReservation(Participant participant) {
        Participant found = findReservation(participant);
        reservations.remove(found);
    }

    private Participant findReservation(Participant participant) {
        return reservations.stream()
                .filter(existing -> existing.isSameAs(participant))
                .findFirst()
                .get();
    }

    @PrimaryPort
    public void resign(Participant participant) {
        Participant found = participants.stream()
                .filter(existing -> existing.isSameAs(participant))
                .findFirst()
                .get();

        participants.add(found);
    }

    @PrimaryPort
    public void start() {
        isFinalized = true;
    }
}
