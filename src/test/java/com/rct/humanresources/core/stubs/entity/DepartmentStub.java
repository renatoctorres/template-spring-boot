package com.rct.humanresources.core.stubs.entity;

import com.rct.humanresources.infra.persistence.entity.Department;

import java.util.List;

public final class DepartmentStub {

    public static Department any() {
        var department = new Department();
        department.setDescription("description");
        department.setId(1L);
        department.setName("Department Name");
        return department;
    }

    public static List<Department> anyList() {
        return List.of(any(), any());
    }

}
