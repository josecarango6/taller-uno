package com.co.talleruno.service;

import com.co.talleruno.persistence.entity.ProjectStatus;
import com.co.talleruno.persistence.entity.ProjectTask;

import java.util.List;

public interface ProjectTaskService {
    List<ProjectTask> findAll();
    List<ProjectTask> findByProjectIdentifier(String projectIdentifier);
    Double getTotalHoursByProjectIdentifier(String projectIdentifier);
    Double getTotalHoursByProjectIdentifierAndStatus(String projectIdentifier, String projectStatus);
    Boolean existsByProjectIdentifier(String projectIdentifier);
    ProjectTask logicDeleteByIdAndProjectIdentifier(Long id, String projectIdentifier);
    boolean existsById(Long id);
    ProjectTask findById(Long id);
    ProjectTask save(ProjectTask projectTask);
    void delete(ProjectTask projectTask);
}
