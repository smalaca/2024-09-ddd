package com.smalaca.trainingoffer.domain.trainingoffer;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public class GroupSize {
    private final int size;

    public GroupSize(int size) {
        this.size = size;
    }
}
