package com.co.talleruno.service;

import com.co.talleruno.persistence.entity.ProjectStatus;
import com.co.talleruno.persistence.entity.ProjectTask;
import com.co.talleruno.persistence.repository.ProjectTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProjectTaskServiceImpl implements ProjectTaskService{

    private final ProjectTaskRepository projectTaskRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProjectTask> findAll() {
        return projectTaskRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectTask findById(Long id) {
        return projectTaskRepository.findById(id).orElse(null);
    }

    public List<ProjectTask> findByProjectIdentifier(String projectIdentifier){
        return projectTaskRepository.findAllByProjectIdentifier(projectIdentifier);
    }

    public Boolean existsByProjectIdentifier(String projectIdentifier){ return projectTaskRepository.existsByProjectIdentifier(projectIdentifier); }

    public boolean existsById(Long id){ return projectTaskRepository.existsById(id); }

    public Double getTotalHoursByProjectIdentifier(String projectIdentifier){
        LinkedList<Double> listHours = new LinkedList<>();
        List<ProjectTask> tasks = projectTaskRepository.findAllByProjectIdentifier(projectIdentifier);
        for( ProjectTask task:tasks){
            if(!(task.getProjectStatus().name().equals("DELETED"))) {
                listHours.push(task.getHours());
            }
        }
        return listHours.stream().reduce(0.0d, (a, b) -> a + b);
    }
    public Double getTotalHoursByProjectIdentifierAndStatus(String projectIdentifier, String projectStatus){
        LinkedList<Double> listHours = new LinkedList<>();
        List<ProjectTask> tasks = projectTaskRepository.findAllByProjectIdentifier(projectIdentifier);
        for( ProjectTask task:tasks){
            if(task.getProjectStatus().name().equals(projectStatus)) {
                listHours.push(task.getHours());
            }
        }
        return listHours.stream().reduce(0.0d, (a, b) -> a + b);
    }


    public ProjectTask logicDeleteByIdAndProjectIdentifier(Long id, String projectIdentifier){

        ProjectTask projectTask = this.findById(id);
        projectTask.setProjectStatus(ProjectStatus.DELETED);
        projectTaskRepository.save(projectTask);

        return projectTask;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ProjectTask projectTask) {
        projectTaskRepository.save(projectTask);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ProjectTask projectTask) {
        projectTaskRepository.delete(projectTask);
    }


}
