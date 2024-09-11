package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;

import java.util.ArrayList;
import java.util.List;

@AggregateRoot
public class TrainingOffer {
    private final List<Participant> reservations = new ArrayList<>();
    private final List<Participant> participants = new ArrayList<>();

    @PrimaryPort
    public void choose(Participant participant) {
        reservations.add(participant);
    }

    @PrimaryPort
    public void buy(ParticipantName participantName, PaymentMethod paymentMethod) {
        Participant found = reservations.stream()
                .filter(participant -> participant.hasName(participantName))
                .findFirst()
                .get();

        reservations.remove(found);
        participants.add(found);
    }

    @PrimaryPort
    public void cancelReservation() {

    }

    @PrimaryPort
    public void resign() {

    }

    @PrimaryPort
    public void start() {

    }
}
