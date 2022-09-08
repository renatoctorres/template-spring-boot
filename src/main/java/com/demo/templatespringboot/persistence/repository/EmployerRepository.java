package com.demo.templatespringboot.persistence.repository;

import com.demo.templatespringboot.persistence.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
    @Modifying
    @Query("delete from Employer e where e.department.id= :departmentId")
    void deleteByDepartmentId(Long departmentId);
}
