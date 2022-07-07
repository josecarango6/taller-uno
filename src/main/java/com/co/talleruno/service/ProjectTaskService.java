package com.co.talleruno.service;

import com.co.talleruno.persistence.entity.ProjectTask;

import java.util.List;

public interface ProjectTaskService {
    List<ProjectTask> findAll();
    List<ProjectTask> findByProjectIdentifier(String projectIdentifier);
    Double getTotalHoursByProjectIdentifier(String projectIdentifier);
    Boolean existsByProjectIdentifier(String projectIdentifier);
    ProjectTask findById(Long id);
    ProjectTask save(ProjectTask projectTask);
    void delete(ProjectTask projectTask);
}
