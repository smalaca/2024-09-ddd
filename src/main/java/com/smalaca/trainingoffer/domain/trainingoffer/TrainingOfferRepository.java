package com.smalaca.trainingoffer.domain.trainingoffer;

import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
public interface TrainingOfferRepository {
    UUID save(TrainingOffer trainingOffer);
}
