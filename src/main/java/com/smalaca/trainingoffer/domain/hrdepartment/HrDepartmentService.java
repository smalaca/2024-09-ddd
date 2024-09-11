package com.smalaca.trainingoffer.domain.hrdepartment;

import com.smalaca.annotation.architecture.SecondaryPort;

import java.util.UUID;

@SecondaryPort
public interface HrDepartmentService {
    boolean doesNotExist(UUID trainerId);
}
