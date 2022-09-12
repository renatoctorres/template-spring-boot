package com.rct.humanresources.core.service;

import com.rct.humanresources.core.model.EmployerDTO;

import java.util.List;

/**
 * EmployerService interface
 */
public interface EmployerService {
    EmployerDTO create(EmployerDTO dto);
    EmployerDTO save(EmployerDTO dto);
    EmployerDTO findById(Long id);
    List<EmployerDTO> findAll();
    void deleteById(Long id);
    EmployerDTO update(EmployerDTO dto);

}
