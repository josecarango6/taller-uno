package com.co.talleruno.service;

import com.co.talleruno.persistence.entity.Project;
import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Project save(Project project);
    void delete(Project project);
    List<Project> findAll();
    Project findById(Long id);

    Optional<Project> findByProjectIdentifier(String projectIdentifier);


}
