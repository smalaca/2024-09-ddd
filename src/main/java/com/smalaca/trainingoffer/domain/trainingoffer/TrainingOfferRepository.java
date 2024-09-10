package com.smalaca.trainingoffer.domain.trainingoffer;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
@SecondaryPort
public interface TrainingOfferRepository {
    UUID save(TrainingOffer trainingOffer);
}
