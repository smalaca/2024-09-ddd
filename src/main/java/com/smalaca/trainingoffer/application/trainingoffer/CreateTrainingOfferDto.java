package com.smalaca.trainingoffer.application.trainingoffer;

import com.smalaca.trainingoffer.domain.trainingoffer.CreateTrainingOfferCommand;
import com.smalaca.trainingoffer.domain.trainingoffer.GroupSize;
import com.smalaca.trainingoffer.domain.trainingoffer.Location;
import com.smalaca.trainingoffer.domain.trainingoffer.Period;
import com.smalaca.trainingoffer.domain.trainingoffer.Price;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CreateTrainingOfferDto(
        UUID trainerId, UUID trainingProgramId, LocalDate startDate, LocalDate endDate, BigDecimal price, int groupSize, String location) {
    CreateTrainingOfferCommand asCreateTrainingOfferCommand() {
        return new CreateTrainingOfferCommand(
                trainerId,
                trainingProgramId,
                new Period(startDate, endDate),
                Price.of(price),
                new GroupSize(groupSize),
                Location.valueOf(location));
    }
}
