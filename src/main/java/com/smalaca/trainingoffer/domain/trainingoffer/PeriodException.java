package com.smalaca.trainingoffer.domain.trainingoffer;

import java.time.LocalDate;

class PeriodException extends RuntimeException {
    private final LocalDate startDate;
    private final LocalDate endDate;

    private PeriodException(String message, LocalDate startDate, LocalDate endDate) {
        super(message);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    static RuntimeException startDateCannotBeFromPast(LocalDate startDate, LocalDate endDate) {
        return new PeriodException("Start date from past", startDate, endDate);
    }

    static RuntimeException startDateMustBeBeforeEndDate(LocalDate startDate, LocalDate endDate) {
        return new PeriodException("Start date must be before end date", startDate, endDate);
    }
}
