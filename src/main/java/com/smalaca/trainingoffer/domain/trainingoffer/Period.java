package com.smalaca.trainingoffer.domain.trainingoffer;

import com.smalaca.annotation.ddd.ValueObject;

import java.time.LocalDate;

@ValueObject
public class Period {
    private final LocalDate start;
    private final LocalDate end;

    public Period(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }
}
