package com.rct.humanresources.core.stubs.dto;

import com.rct.humanresources.core.model.DepartmentDTO;

import java.util.List;
import java.util.Random;

public final class DepartmentDTOStub {
    static Random random = new Random();
    public static DepartmentDTO any() {
        var dto = new DepartmentDTO();
        dto.setDescription("Department description");
        dto.setName("Department Name");
        dto.setId(random.nextLong());

        return dto;
    }

    public static List<DepartmentDTO> anyList() {
        return List.of(any(), any());
    }

}
