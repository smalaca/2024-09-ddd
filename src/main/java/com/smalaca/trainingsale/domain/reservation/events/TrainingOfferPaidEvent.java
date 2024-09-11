package com.smalaca.trainingsale.domain.reservation.events;

import com.smalaca.annotation.ddd.DomainEvent;

import java.util.UUID;

@DomainEvent
public record TrainingOfferPaidEvent(UUID trainingOfferId, String firstName, String lastName) {
}
