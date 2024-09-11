package com.smalaca.trainingoffer.domain.trainingoffer;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.annotation.ddd.ValueObject;

import java.time.LocalDate;

@ValueObject
public class Period {
    private final LocalDate start;
    private final LocalDate end;

    private Period(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    @Factory
    public static Period of(LocalDate startDate, LocalDate endDate) {
        if (LocalDate.now().isAfter(startDate)) {
            throw PeriodException.startDateCannotBeFromPast(startDate, endDate);
        }

        if (startDate.isAfter(endDate)) {
            throw PeriodException.startDateMustBeBeforeEndDate(startDate, endDate);
        }

        return new Period(startDate, endDate);
    }
}
