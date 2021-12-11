package com.dslprog.cursospringboot.repository;

import com.dslprog.cursospringboot.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectJpaRepository extends JpaRepository<Project, Long>, JpaSpecificationExecutor<Project> {
}


