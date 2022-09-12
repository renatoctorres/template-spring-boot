package com.rct.humanresources.core.stubs.entity;

import com.rct.humanresources.infra.persistence.entity.Employer;

import java.util.List;
import java.util.Random;

public class EmployerStub {

    static Random random = new Random();

    public static Employer any() {
        var employer = new Employer();
        employer.setFullName("Full Name");
        employer.setId(random.nextLong());
        employer.setDepartment(DepartmentStub.any());
        return employer;
    }

    public static List<Employer> anyList() {
        return List.of(any(), any());
    }
}
