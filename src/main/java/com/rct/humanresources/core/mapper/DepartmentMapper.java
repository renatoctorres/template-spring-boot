package com.rct.humanresources.core.mapper;

import com.rct.humanresources.core.model.DepartmentDTO;
import com.rct.humanresources.infra.persistence.entity.Department;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Department - MapStruct Mapper interface
 */
@Mapper(componentModel = "spring" , uses = DepartmentMapper.class)
public interface DepartmentMapper {
    DepartmentDTO fromModel(Department department);
    Department fromDTO(DepartmentDTO departmentDTO);
    List<DepartmentDTO> fromModels(List<Department> departments);
    List<Department> fromDTOs(List<DepartmentDTO> departmentDTOs);
}
