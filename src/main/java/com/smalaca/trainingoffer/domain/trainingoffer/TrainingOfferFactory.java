package com.smalaca.trainingoffer.domain.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.trainingoffer.domain.hrdepartment.HrDepartmentService;
import com.smalaca.trainingoffer.domain.trainingprogram.TrainingProgramService;
import org.springframework.stereotype.Service;

@Factory
@Service
public class TrainingOfferFactory {
    private final TrainingProgramService trainingProgramService;
    private final HrDepartmentService hrDepartmentService;

    TrainingOfferFactory(TrainingProgramService trainingProgramService, HrDepartmentService hrDepartmentService) {
        this.trainingProgramService = trainingProgramService;
        this.hrDepartmentService = hrDepartmentService;
    }

    @PrimaryPort
    public TrainingOffer create(CreateTrainingOfferCommand command) {
        if (trainingProgramService.doesNotExist(command.trainingProgramId())) {
            throw new TrainingProgramDoesNotExistException(command.trainingProgramId());
        }

        if (hrDepartmentService.doesNotExist(command.trainerId())) {
            throw new TrainerDoesNotExistException(command.trainerId());
        }

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
