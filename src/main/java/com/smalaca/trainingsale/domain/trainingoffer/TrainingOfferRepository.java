package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
@SecondaryPort
public interface TrainingOfferRepository {
    TrainingOffer findById(UUID id);

    void update(TrainingOffer trainingOffer);
}
