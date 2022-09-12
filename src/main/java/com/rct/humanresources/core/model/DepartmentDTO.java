package com.rct.humanresources.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Department DTO
 */
@Getter
@Setter
@NoArgsConstructor
public class DepartmentDTO {
    @JsonProperty("codigo")
    private Long id;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("descricao")
    private String description;
}
