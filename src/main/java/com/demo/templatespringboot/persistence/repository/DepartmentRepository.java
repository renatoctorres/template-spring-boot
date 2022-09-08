package com.demo.templatespringboot.persistence.repository;

import com.demo.templatespringboot.persistence.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
