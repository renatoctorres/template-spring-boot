package com.rct.humanresources.core.mapper;

import com.rct.humanresources.core.model.EmployerDTO;
import com.rct.humanresources.infra.persistence.entity.Employer;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * Employer - MapStruct Mapper interface
 */
@Mapper(componentModel = "spring")
public interface EmployerMapper {
    EmployerDTO fromModel(Employer employer);
    Employer fromDTO(EmployerDTO employerDTO);
    List<EmployerDTO> fromModels(List<Employer> employers);
    List<Employer> fromDTOs(List<EmployerDTO> employerDTOs);
}
