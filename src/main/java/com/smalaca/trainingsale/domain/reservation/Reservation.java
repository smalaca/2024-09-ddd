package com.smalaca.trainingsale.domain.reservation;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.trainingsale.domain.participant.Participant;
import com.smalaca.trainingsale.domain.price.Price;

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
}
