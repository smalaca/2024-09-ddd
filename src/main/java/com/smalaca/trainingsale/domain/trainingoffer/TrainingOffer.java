package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;

@AggregateRoot
public class TrainingOffer {

    @PrimaryPort
    public void choose() {

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
