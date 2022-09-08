package com.demo.templatespringboot.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DepartmentDTO {
    @JsonProperty("codigo")
    private Long id;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("descricao")
    private String description;
}
