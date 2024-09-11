package com.smalaca.trainingoffer.domain.trainingoffer;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public class GroupSize {
    private final int size;

    private GroupSize(int size) {
        this.size = size;
    }

    public static GroupSize of(int size) {
        if (size < 1 || size > 15) {
            throw new InvalidGroupSizeException(size);
        }

        return new GroupSize(size);
    }
}
