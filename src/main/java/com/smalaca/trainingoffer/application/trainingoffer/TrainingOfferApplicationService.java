package com.smalaca.trainingoffer.application.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.trainingoffer.domain.trainingoffer.TrainingOffer;
import com.smalaca.trainingoffer.domain.trainingoffer.TrainingOfferRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class TrainingOfferApplicationService {
    private final TrainingOfferRepository trainingOfferRepository;

    TrainingOfferApplicationService(TrainingOfferRepository trainingOfferRepository) {
        this.trainingOfferRepository = trainingOfferRepository;
    }

    @Transactional
    @PrimaryAdapter
    public UUID create() {
        // 1. transformacja na język domenowy: 0 ... *

        // 2. wywołanie metody z domeny: 1
        TrainingOffer trainingOffer = new TrainingOffer();

        // 3. zapisanie wyników: 1 ... *
        return trainingOfferRepository.save(trainingOffer);
    }
}
