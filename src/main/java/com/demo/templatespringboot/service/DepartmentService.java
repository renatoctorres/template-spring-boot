package com.demo.templatespringboot.service;

import com.demo.templatespringboot.api.exception.NoSuchElementFoundException;
import com.demo.templatespringboot.infra.converter.DepartmentConverter;
import com.demo.templatespringboot.api.model.DepartmentDTO;
import com.demo.templatespringboot.persistence.entity.Department;
import com.demo.templatespringboot.persistence.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository repository;
    @Autowired
    DepartmentConverter converter;
    @Autowired
    MessageSource messageSource;

    public DepartmentDTO create(DepartmentDTO dto) {
        return save(dto);
    }

    private DepartmentDTO save(DepartmentDTO dto) {
        Department department =  this.repository.save(converter.toModel(dto));
        return converter.fromModel(department);
    }

    public DepartmentDTO findById(Long id) {
        if (this.repository.findById(id).isPresent()){
            throw new NoSuchElementFoundException();
        }else{
            return converter.fromModel(this.repository.findById(id).get());
        }

    }

    public List<DepartmentDTO> findAll() {
        if (this.repository.findAll().isEmpty()){
            return Collections.emptyList();
        }
        return converter.fromModelList(this.repository.findAll());

    }

    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    public DepartmentDTO update(DepartmentDTO dto) {
        return save(dto);
    }

}
