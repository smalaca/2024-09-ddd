package com.smalaca.trainingoffer.domain.trainingoffer.events;

import com.smalaca.annotation.ddd.DomainEvent;

import java.math.BigDecimal;
import java.util.UUID;

@DomainEvent
public record TrainingOfferPublishedEvent(UUID trainerId, UUID trainingProgramId, BigDecimal price) {
}
