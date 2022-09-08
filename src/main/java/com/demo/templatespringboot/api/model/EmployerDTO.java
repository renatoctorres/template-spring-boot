package com.demo.templatespringboot.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployerDTO {
    @JsonProperty("codigo")
    private Long id;
    @JsonProperty("nomeCompleto")
    private String fullName;

}
