package com.smalaca.trainingoffer.domain.trainingprogram;

import com.smalaca.annotation.architecture.SecondaryPort;

import java.util.UUID;

@SecondaryPort
public interface TrainingProgramService {
    boolean exists(UUID uuid);
}
