package com.demo.templatespringboot.service;

import com.demo.templatespringboot.api.exception.NoSuchElementFoundException;
import com.demo.templatespringboot.infra.converter.EmployerConverter;
import com.demo.templatespringboot.api.model.EmployerDTO;
import com.demo.templatespringboot.persistence.entity.Employer;
import com.demo.templatespringboot.persistence.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class EmployerService {
    @Autowired
    EmployerRepository repository;
    @Autowired
    EmployerConverter converter;

    public EmployerDTO create(EmployerDTO dto) {
        return save(dto);
    }

    private EmployerDTO save(EmployerDTO dto) {
        Employer employer =  this.repository.save(converter.toModel(dto));
        return converter.fromModel(employer);
    }

    public EmployerDTO findById(Long id) {
        if (this.repository.findById(id).isEmpty()){
            throw new NoSuchElementFoundException();
        }
        return converter.fromModel(this.repository.findById(id).get());

    }

    public List<EmployerDTO> findAll() {
        if (this.repository.findAll().isEmpty()){
            return Collections.emptyList();
        }
       return converter.fromModelList(this.repository.findAll());

    }

    public void delete(EmployerDTO dto) {
        this.repository.delete(converter.toModel(dto));
    }

    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    public EmployerDTO update(EmployerDTO dto) {
        return save(dto);
    }

}
