package com.rct.humanresources.infra.persistence.repository;

import com.rct.humanresources.infra.persistence.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * EmployerRepository - JpaRepository implementation
 */
public interface EmployerRepository extends JpaRepository<Employer, Long> {
    /**
     * Delete Employer by Department ID
     * @param departmentId Department ID
     */
    @Modifying
    @Query("delete from Employer e where e.department.id= :departmentId")
    void deleteByDepartmentId(Long departmentId);
}
