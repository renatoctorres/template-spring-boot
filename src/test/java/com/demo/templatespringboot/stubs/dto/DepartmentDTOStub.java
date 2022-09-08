package com.demo.templatespringboot.stubs.dto;

import com.demo.templatespringboot.api.model.DepartmentDTO;
import com.demo.templatespringboot.persistence.entity.Department;

import java.util.List;
import java.util.Random;

public final class DepartmentDTOStub {

    static Random random = new Random();

    public static DepartmentDTO any() {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setDescription("description");
        dto.setId(random.nextLong());
        dto.setName("Department Name");
        return dto;
    }

    public static List<DepartmentDTO> anyList() {
        return List.of(any(), any());
    }

}
