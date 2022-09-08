package com.demo.templatespringboot.service;

import com.demo.templatespringboot.api.exception.NoSuchElementFoundException;
import com.demo.templatespringboot.infra.converter.DepartmentConverter;
import com.demo.templatespringboot.api.model.DepartmentDTO;
import com.demo.templatespringboot.persistence.entity.Department;
import com.demo.templatespringboot.persistence.repository.DepartmentRepository;
import com.demo.templatespringboot.persistence.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import static java.util.Collections.emptyList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository repository;
    @Autowired
    EmployerRepository employerRepository;

    @Autowired
    DepartmentConverter converter;
    @Autowired
    MessageSource messageSource;

    public DepartmentDTO create(DepartmentDTO dto) {
        return save(dto);
    }

    DepartmentDTO save(DepartmentDTO dto) {
        Department department =  this.repository.save(converter.toModel(dto));
        return converter.fromModel(department);
    }

    public DepartmentDTO findById(Long id) {
        Optional<Department> optDepartment = this.repository.findById(id);
        if (optDepartment.isEmpty()){
            throw new NoSuchElementFoundException();
        }else{
            return converter.fromModel(optDepartment.get());
        }
    }

    public List<DepartmentDTO> findAll() {
        if (this.repository.findAll().isEmpty()){
            return emptyList();
        }
        return converter.fromModelList(this.repository.findAll());

    }
    @Transactional
    public void deleteById(Long id) {
        this.employerRepository.deleteByDepartmentId(id);
        this.repository.deleteById(id);
    }

    public DepartmentDTO update(DepartmentDTO dto) {
        return save(dto);
    }

}
