package com.co.talleruno.controller;

import com.co.talleruno.controller.docs.ProjectDocs;
import com.co.talleruno.helpers.Response;
import com.co.talleruno.helpers.ResponseBuild;
import com.co.talleruno.mapper.ProjectInDtoToProject;
import com.co.talleruno.persistence.entity.Project;
import com.co.talleruno.service.ProjectService;
import com.co.talleruno.service.dto.ProjectInDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/projects/")
@RequiredArgsConstructor
public class ProjectController implements ProjectDocs {

    private final ProjectService projectService;
    private final ProjectInDtoToProject mapper;
    private final ResponseBuild build;

    //private final ControllerResponse response;

    @Override
    @PostMapping()
    public Response save(@Valid @RequestBody ProjectInDTO project, BindingResult result) {
        if (result.hasErrors()) {
            return build.failed(formatMessage(result));
        }

        projectService.save(mapper.map(project));
        return build.success(project);

    }

    @GetMapping()
    public List<Project> index() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Project show(@PathVariable Long id) {
        return projectService.findById(id);
    }



    /*
    @PutMapping("/{id}")
    public Project update(@RequestBody Project project, @PathVariable Long id){
        Project projectActual = projectService.findById(id);
        projectActual.setProjectName(project.getProjectName());
        projectActual.setProjectIdentifier(project.getProjectIdentifier());
        projectActual.setDescripcion(project.getDescripcion());
        projectActual.setStartDate(project.getStartDate());
        projectActual.setEndDate(project.getEndDate());
        projectActual.setBacklog(project.getBacklog());

        return projectService.save(projectActual);
    }
     */

    /*
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Project project = projectService.findById(id);
        projectService.delete(project);
        return build.success(project);
    }
     */

    private List<Map<String, String>> formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
            .map(error -> {
                Map<String, String> err = new HashMap<>();
                err.put(error.getField(), error.getDefaultMessage());
                return err;
            }).collect(Collectors.toList());
        return errors;
    }

}
