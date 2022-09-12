package com.rct.humanresources.core.service;

import com.rct.humanresources.core.model.DepartmentDTO;

import java.util.List;

/**
 * Department Service - Interface
 */
public interface DepartmentService {
    DepartmentDTO create(DepartmentDTO dto);
    DepartmentDTO save(DepartmentDTO dto);
    DepartmentDTO findById(Long id);
    List<DepartmentDTO> findAll();
    void deleteById(Long id);
    DepartmentDTO update(DepartmentDTO dto);

}
