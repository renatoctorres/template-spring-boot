package com.rct.humanresources.infra.persistence.repository;

import com.rct.humanresources.infra.persistence.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DepartmentRepository - JpaRepository implementation
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
