package com.smalaca.trainingsale.infrastructure.repository.trainingoffer;

import com.smalaca.annotation.architecture.SecondaryAdapter;
import com.smalaca.trainingsale.domain.trainingoffer.TrainingOffer;
import com.smalaca.trainingsale.domain.trainingoffer.TrainingOfferRepository;

import java.util.Optional;
import java.util.UUID;

@SecondaryAdapter
public class JpaTrainingOfferRepository implements TrainingOfferRepository {
    @Override
    public TrainingOffer findById(UUID id) {
        Optional<TrainingOffer> found = null;

        if (found.isEmpty()) {
            throw new NotFoundTrainingOfferException(id);
        }

        return found.get();
    }

    @Override
    public void update(TrainingOffer trainingOffer) {

    }
}
