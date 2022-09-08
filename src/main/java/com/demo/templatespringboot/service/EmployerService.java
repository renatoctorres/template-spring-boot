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
import java.util.Optional;

@Service
public class EmployerService {
    @Autowired
    EmployerRepository repository;
    @Autowired
    EmployerConverter converter;

    public EmployerDTO create(EmployerDTO dto) {
        return save(dto);
    }

    EmployerDTO save(EmployerDTO dto) {
        Employer employer =  this.repository.save(converter.toModel(dto));
        return converter.fromModel(employer);
    }

    public EmployerDTO findById(Long id) {
        Optional<Employer> optEmployer = this.repository.findById(id);
        if (optEmployer.isEmpty()){
            throw new NoSuchElementFoundException();
        }else{
            return converter.fromModel(optEmployer.get());
        }

    }

    public List<EmployerDTO> findAll() {
        if (this.repository.findAll().isEmpty()){
            return Collections.emptyList();
        }
       return converter.fromModelList(this.repository.findAll());

    }

    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
    public EmployerDTO update(EmployerDTO dto) {
        return save(dto);
    }

}
