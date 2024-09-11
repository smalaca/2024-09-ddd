package com.smalaca.trainingoffer.application.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.trainingoffer.domain.trainingoffer.CreateTrainingOfferCommand;
import com.smalaca.trainingoffer.domain.trainingoffer.TrainingOffer;
import com.smalaca.trainingoffer.domain.trainingoffer.TrainingOfferFactory;
import com.smalaca.trainingoffer.domain.trainingoffer.TrainingOfferRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class TrainingOfferApplicationService {
    private final TrainingOfferRepository trainingOfferRepository;
    private final TrainingOfferFactory trainingOfferFactory;

    TrainingOfferApplicationService(TrainingOfferRepository trainingOfferRepository, TrainingOfferFactory trainingOfferFactory) {
        this.trainingOfferRepository = trainingOfferRepository;
        this.trainingOfferFactory = trainingOfferFactory;
    }

    @Transactional
    @PrimaryAdapter
    public UUID create(CreateTrainingOfferDto dto) {
        // 1. transformacja na język domenowy: 0 ... *
        CreateTrainingOfferCommand command = dto.asCreateTrainingOfferCommand();

        // 2. wywołanie metody z domeny: 1
        TrainingOffer trainingOffer = trainingOfferFactory.create(command);

        // 3. zapisanie wyników: 1 ... *
        return trainingOfferRepository.save(trainingOffer);
    }

    @Transactional
    @PrimaryAdapter
    public void publish(UUID id) {
        TrainingOffer trainingOffer = trainingOfferRepository.findById(id);

        trainingOffer.publish();

        trainingOfferRepository.update(trainingOffer);
    }
}
