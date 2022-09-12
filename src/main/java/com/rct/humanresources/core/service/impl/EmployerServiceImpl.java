package com.rct.humanresources.core.service.impl;

import com.rct.humanresources.infra.delivery.exception.NoSuchElementFoundException;
import com.rct.humanresources.core.model.EmployerDTO;
import com.rct.humanresources.core.mapper.EmployerMapper;
import com.rct.humanresources.core.service.EmployerService;
import com.rct.humanresources.infra.persistence.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;

/**
 * Employer Service Implementation
 */
@Service
public class EmployerServiceImpl implements EmployerService {
    EmployerRepository repository;
    EmployerMapper mapper;
    @Autowired
    EmployerServiceImpl(EmployerRepository repository, EmployerMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Create EmployerDTO
     * @param dto EmployerDTO
     * @return EmployerDTO
     */
    public EmployerDTO create(EmployerDTO dto) {
        return save(dto);
    }

    /**
     * Save EmployerDTO
     * @param dto EmployerDTO
     * @return EmployerDTO
     */
    public EmployerDTO save(EmployerDTO dto) {
        var employer =  this.repository.save(mapper.fromDTO(dto));
        return mapper.fromModel(employer);
    }

    /**
     * Find EmployerDTO by id
     * @param id Long
     * @return EmployerDTO
     */
    public EmployerDTO findById(Long id) {
        var optEmployer = this.repository.findById(id);
        if (optEmployer.isEmpty()){
            throw new NoSuchElementFoundException();
        }else{
            return mapper.fromModel(optEmployer.get());
        }
    }

    /**
     * Find All EmployerDTOs
     * @return EmployerDTO List
     */
    public List<EmployerDTO> findAll() {
        if (this.repository.findAll().isEmpty()){
            return emptyList();
        }
       return mapper.fromModels(this.repository.findAll());
    }

    /**
     * Delete EmployerDTO by id
     * @param id Long
     */
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
    public EmployerDTO update(EmployerDTO dto) {
        return save(dto);
    }

}
