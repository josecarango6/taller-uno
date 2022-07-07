package com.co.talleruno.controller;

import com.co.talleruno.controller.docs.BacklogDocs;
import com.co.talleruno.helpers.ControllerResponse;
import com.co.talleruno.helpers.Response;
import com.co.talleruno.helpers.ResponseBuild;
import com.co.talleruno.mapper.BacklogInDtoToBacklog;
import com.co.talleruno.persistence.entity.Backlog;
import com.co.talleruno.persistence.entity.Project;
import com.co.talleruno.service.BacklogService;
import com.co.talleruno.service.ProjectService;
import com.co.talleruno.service.dto.BacklogInDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backlogs/")
@RequiredArgsConstructor
public class BacklogController implements BacklogDocs {

    private final BacklogService backlogService;
    private final ProjectService projectService;
    private final BacklogInDtoToBacklog mapper;
    private final ResponseBuild build;

    private final ControllerResponse response;


    @Override
    @PostMapping()
    public ResponseEntity save(@Valid @RequestBody BacklogInDTO backlog, BindingResult result) {
        if (result.hasErrors()) {
            return response.buildResponse(result, HttpStatus.BAD_REQUEST);
        }

        Optional<Project> project = projectService.findByProjectIdentifier(
            backlog.getProjectIdentifier());

        if (!project.isPresent()) {
            String message = "Project identifier does not exist";
            return response.buildResponse(message, HttpStatus.BAD_REQUEST);
        }

        Backlog something = backlogService.save(
            mapper.map(backlog));
        return response.buildResponse(something, HttpStatus.CREATED);
    }

    /*
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Backlog backlog = backlogService.findById(id);
        backlogService.delete(backlog);
        return build.success(backlog);
    }
     */

    @GetMapping()
    public Response findAll() {
        return build.success(backlogService.findAll());
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id) {
        return build.success(backlogService.findById(id));
    }

    /*
    @PutMapping("/{id}")
    public Backlog update(@RequestBody Backlog backlog, @PathVariable Long id){
        Backlog backlogActual = backlogService.findById(id);
        backlogActual.setProjectIdentifier(backlog.getProjectIdentifier());
        backlogActual.setProject(backlog.getProject());
        backlogActual.setProjectTask(backlog.getProjectTask());

        return backlogService.save(backlogActual);
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
