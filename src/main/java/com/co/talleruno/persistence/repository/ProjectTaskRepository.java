package com.co.talleruno.persistence.repository;

import com.co.talleruno.persistence.entity.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long> {

    List<ProjectTask> findAllByProjectIdentifier(String projectIdentifier);

    Boolean existsByProjectIdentifier(String projectIdentifier);


}
