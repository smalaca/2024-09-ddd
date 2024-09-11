package com.smalaca.trainingoffer.domain.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.trainingoffer.domain.trainingprogram.TrainingProgramService;
import org.springframework.stereotype.Service;

@Factory
@Service
public class TrainingOfferFactory {
    private final TrainingProgramService trainingProgramService;

    TrainingOfferFactory(TrainingProgramService trainingProgramService) {
        this.trainingProgramService = trainingProgramService;
    }

    @PrimaryPort
    public TrainingOffer create(CreateTrainingOfferCommand command) {
        if (trainingProgramService.exists(command.trainingProgramId())) {
            return new TrainingOffer.Builder()
                    .withTrainerId(command.trainerId())
                    .withTrainingProgramId(command.trainingProgramId())
                    .withPeriod(command.period())
                    .withPrice(command.price())
                    .withMaxGroupSize(command.groupSize())
                    .withLocation(command.location())
                    .build();
        } else {
            throw new TrainingProgramDoesNotExistException(command.trainingProgramId());
        }
    }
}
