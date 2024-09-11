package com.smalaca.trainingsale.domain.trainingoffer.events;

import com.smalaca.annotation.ddd.DomainEvent;

import java.util.UUID;

@DomainEvent
public record ResignedFromTrainingEvent(UUID trainingOfferId, String firstName, String lastName) {
}
