package com.demo.templatespringboot.stubs.entity;

import com.demo.templatespringboot.persistence.entity.Department;

import java.util.List;

public final class DepartmentStub {

    public static Department any() {
        Department department = new Department();
        department.setDescription("description");
        department.setId(1L);
        department.setName("Department Name");
        return department;
    }

    public static List<Department> anyList() {
        return List.of(any(), any());
    }

}
