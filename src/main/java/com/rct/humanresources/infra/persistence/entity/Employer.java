package com.rct.humanresources.infra.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.AUTO;
import static org.hibernate.annotations.FetchMode.SELECT;

/**
 * Employer - Jakarta Entity
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employer {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String fullName;
    @ManyToOne(fetch = LAZY)
    @Fetch(SELECT)
    private Department department;
    private Boolean active;


}
