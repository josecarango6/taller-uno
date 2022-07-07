package com.co.talleruno.controller.docs;

import com.co.talleruno.helpers.Response;
import com.co.talleruno.service.dto.ProjectTaskInDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Project Task")
public interface ProjectTaskDocs {

    @Operation(summary = "Create a project task")
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "201",
                description = "Project task created",
                content = {
                    @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
                }
            )
        }
    )
    Response save(@RequestBody ProjectTaskInDTO projectTaskInDTO, BindingResult bindingResult);
}