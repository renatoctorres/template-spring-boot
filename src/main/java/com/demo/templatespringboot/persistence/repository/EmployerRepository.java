package com.demo.templatespringboot.persistence.repository;

import com.demo.templatespringboot.persistence.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
