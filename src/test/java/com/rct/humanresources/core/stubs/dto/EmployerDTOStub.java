package com.rct.humanresources.core.stubs.dto;

import com.rct.humanresources.core.model.EmployerDTO;

import java.util.List;
import java.util.Random;


public class EmployerDTOStub {
    static Random random = new Random();

    public static EmployerDTO any(){
        var dto = new EmployerDTO();
        dto.setFullName("Full Name");
        dto.setId(random.nextLong());
        return dto;
    }

    public static List<EmployerDTO> anyList() {
        return List.of(any(), any());
    }
}
