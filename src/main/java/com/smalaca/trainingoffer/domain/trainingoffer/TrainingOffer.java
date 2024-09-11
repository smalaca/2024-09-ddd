package com.smalaca.trainingoffer.domain.trainingoffer;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.annotation.ddd.Factory;

import java.util.UUID;

@AggregateRoot
public class TrainingOffer {
    private final UUID trainerId;
    private final UUID trainingProgramId;
    private final Period period;
    private final Price price;
    private final GroupSize groupSize;
    private final Location location;

    private TrainingOffer(Builder builder) {
        trainerId = builder.trainerId;
        trainingProgramId = builder.trainingProgramId;
        period = builder.period;
        price = builder.price;
        groupSize = builder.groupSize;
        location = builder.location;
    }

    @Factory
    static class Builder {
        private UUID trainerId;
        private UUID trainingProgramId;
        private Period period;
        private Price price;
        private GroupSize groupSize;
        private Location location;

        public TrainingOffer build() {
            return new TrainingOffer(this);
        }

        Builder withTrainerId(UUID trainerId) {
            this.trainerId = trainerId;
            return this;
        }

        Builder withTrainingProgramId(UUID trainingProgramId) {
            this.trainingProgramId = trainingProgramId;
            return this;
        }

        Builder withPeriod(Period period) {
            this.period = period;
            return this;
        }

        Builder withPrice(Price price) {
            this.price = price;
            return this;
        }

        Builder withMaxGroupSize(GroupSize groupSize) {
            this.groupSize = groupSize;
            return this;
        }

        Builder withLocation(Location location) {
            this.location = location;
            return this;
        }
    }
}
