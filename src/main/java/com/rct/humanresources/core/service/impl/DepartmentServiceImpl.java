package com.rct.humanresources.core.service.impl;

import com.rct.humanresources.infra.delivery.exception.NoSuchElementFoundException;
import com.rct.humanresources.core.model.DepartmentDTO;
import com.rct.humanresources.core.mapper.DepartmentMapper;
import com.rct.humanresources.core.service.DepartmentService;
import com.rct.humanresources.infra.persistence.repository.DepartmentRepository;
import com.rct.humanresources.infra.persistence.repository.EmployerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;

/**
 * Department Service Implementation
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;
    private final EmployerRepository employerRepository;
    private final DepartmentMapper mapper;
    private final MessageSource messageSource;

    /**
     *
     * @param repository DepartmentRepository
     * @param employerRepository EmployerRepository
     * @param mapper EmployerMapper
     * @param messageSource MessageSource
     */
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository repository, EmployerRepository employerRepository
    , DepartmentMapper mapper, MessageSource messageSource){
        this.repository = repository;
        this.employerRepository = employerRepository;
        this.mapper = mapper;
        this.messageSource = messageSource;
    }

    /**
     * Create DepartmentDTO
     * @param dto DepartmentDTO
     * @return DepartmentDTO
     */
    public DepartmentDTO create(DepartmentDTO dto) {
        return save(dto);
    }

    /**
     * Save DepartmentDTO
     * @param dto DepartmentDTO
     * @return DepartmentDTO
     */
    public DepartmentDTO save(DepartmentDTO dto) {
        var department =  this.repository.save(mapper.fromDTO(dto));
        return mapper.fromModel(department);
    }

    /**
     * Find Department by id
     * @param id Long
     * @return DepartmentDTO
     */
    public DepartmentDTO findById(Long id) {
        var optDepartment = this.repository.findById(id);
        if (optDepartment.isEmpty()){
            throw new NoSuchElementFoundException();
        }else{
            return mapper.fromModel(optDepartment.get());
        }
    }

    /**
     * Find All Departments
     * @return DepartmentDTO List
     */
    public List<DepartmentDTO> findAll() {
        if (this.repository.findAll().isEmpty()){
            return emptyList();
        }
        return mapper.fromModels(this.repository.findAll());

    }

    /**
     * Delete Employer by id
     * @param id Long
     */
    @Transactional
    public void deleteById(Long id) {
        this.employerRepository.deleteByDepartmentId(id);
        this.repository.deleteById(id);
    }

    /**
     * Update Department
     * @param dto DepartmentDTO
     * @return DepartmentDTO
     */
    public DepartmentDTO update(DepartmentDTO dto) {
        return save(dto);
    }

}
