package com.co.talleruno.persistence.repository;

import com.co.talleruno.persistence.entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findByProjectIdentifier(String projectIdentifier);
}
