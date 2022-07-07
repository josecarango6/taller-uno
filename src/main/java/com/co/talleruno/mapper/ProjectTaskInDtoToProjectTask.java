package com.co.talleruno.mapper;

import com.co.talleruno.persistence.entity.ProjectStatus;
import com.co.talleruno.persistence.entity.ProjectTask;
import com.co.talleruno.service.dto.ProjectTaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProjectTaskInDtoToProjectTask implements IMapper<ProjectTaskInDTO, ProjectTask>{

    @Override
    public ProjectTask map(ProjectTaskInDTO in) {
        ProjectTask projectTask = new ProjectTask();
        projectTask.setName(in.getName());
        projectTask.setSummary(in.getSummary());
        projectTask.setAcceptanceCriteria(in.getAcceptanceCriteria());
        //projectTask.setProjectStatus(ProjectStatus.NOT_STARED);
        projectTask.setProjectStatus(in.getProjectStatus());
        projectTask.setPriority(in.getPriority());
        projectTask.setHours(in.getHours());
        projectTask.setStartDate(LocalDateTime.now());
        projectTask.setEndDate(in.getEndDate());
        projectTask.setProjectIdentifier(in.getProjectIdentifier());
        return projectTask;
    }
}
