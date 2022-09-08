package com.demo.templatespringboot.stubs.dto;

import com.demo.templatespringboot.api.model.EmployerDTO;
import com.demo.templatespringboot.persistence.entity.Employer;

import java.util.List;
import java.util.Random;


public class EmployerDTOStub {
    static Random random = new Random();

    public static EmployerDTO any(){
        EmployerDTO dto = new EmployerDTO();
        dto.setFullName("Full Name");
        dto.setId(random.nextLong());
        return dto;
    }

    public static List<EmployerDTO> anyList() {
        return List.of(any(), any());
    }
}
