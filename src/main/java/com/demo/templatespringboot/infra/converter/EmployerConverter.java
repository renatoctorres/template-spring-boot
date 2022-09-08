package com.demo.templatespringboot.infra.converter;

import com.demo.templatespringboot.api.model.EmployerDTO;
import com.demo.templatespringboot.persistence.entity.Employer;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployerConverter {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployerConverter.class);
    @Autowired
    private final ModelMapper mapper;

    public EmployerConverter(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Employer toModel(EmployerDTO dto) {
        LOGGER.info("Convert Employer Request to Model ID: {}", dto.getId());
        return mapper.map(dto, Employer.class);
    }

    public EmployerDTO fromModel(Employer model) {
        LOGGER.info("Convert Model to EmployerRequest ID: {}", model.getId());
        return mapper.map(model, EmployerDTO.class);
    }

    public List<Employer> toModelList(List<EmployerDTO> dtoList) {
        return dtoList.stream()
                .map(item -> mapper.map(item, Employer.class))
                .collect(Collectors.toList());
    }

    public List<EmployerDTO> fromModelList(List<Employer> modelList) {
        return modelList.stream()
                .map(item -> mapper.map(item, EmployerDTO.class))
                .collect(Collectors.toList());
    }

}
