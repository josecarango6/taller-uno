package com.co.talleruno.service;

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

    public Double getTotalHoursByProjectIdentifier(String projectIdentifier){

        LinkedList<Double> listHours = new LinkedList<>();

        List<ProjectTask> tasks = projectTaskRepository.findAllByProjectIdentifier(projectIdentifier);

        for( ProjectTask task:tasks){
            listHours.push(task.getHours());
        }

        return listHours.stream().reduce(0.0d, (a, b) -> a + b);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProjectTask save(ProjectTask projectTask) {
        projectTaskRepository.save(projectTask);
        return projectTask;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ProjectTask projectTask) {
        projectTaskRepository.delete(projectTask);
    }


}
