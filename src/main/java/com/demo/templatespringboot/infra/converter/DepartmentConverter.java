package com.demo.templatespringboot.infra.converter;

import com.demo.templatespringboot.api.model.DepartmentDTO;
import com.demo.templatespringboot.persistence.entity.Department;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentConverter {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentConverter.class);
    @Autowired
    private final ModelMapper mapper;

    public DepartmentConverter(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Department toModel(DepartmentDTO dto) {
        LOGGER.info( "Convert Department Request to Model ID: {}", dto.getId());
        return mapper.map(dto,Department.class);
    }

    public DepartmentDTO fromModel(Department model) {
        LOGGER.info( "Convert Model to DepartmentRequest ID: {}", model.getId());
        return mapper.map(model,DepartmentDTO.class);
    }

    public List<Department> toModelList(List<DepartmentDTO> dtoList) {
        return dtoList.stream()
                .map(item -> mapper.map(item, Department.class))
                .collect(Collectors.toList());
    }

    public List<DepartmentDTO> fromModelList(List<Department> modelList) {
        return modelList.stream()
                .map(item -> mapper.map(item, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

}
