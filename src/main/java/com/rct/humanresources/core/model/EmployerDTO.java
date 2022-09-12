package com.rct.humanresources.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Employer DTO
 */
@Getter
@Setter
@NoArgsConstructor
public class EmployerDTO {
    @JsonProperty("codigo")
    private Long id;
    @JsonProperty("nomeCompleto")
    private String fullName;

}
