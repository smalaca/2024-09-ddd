package com.smalaca.trainingoffer.domain.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.Factory;

@Factory
public class TrainingOfferFactory {
    @PrimaryPort
    public TrainingOffer create(CreateTrainingOfferCommand command) {
        return new TrainingOffer.Builder()
                .withTrainerId(command.trainerId())
                .withTrainingProgramId(command.trainingProgramId())
                .withPeriod(command.period())
                .withPrice(command.price())
                .withMaxGroupSize(command.groupSize())
                .withLocation(command.location())
                .build();
    }
}
