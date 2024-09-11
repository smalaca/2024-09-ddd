package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;

import java.util.ArrayList;
import java.util.List;

@AggregateRoot
public class TrainingOffer {
    private final List<Participant> reservations = new ArrayList<>();

    @PrimaryPort
    public void choose(Participant participant) {
        reservations.add(participant);
    }

    @PrimaryPort
    public void buy() {
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
