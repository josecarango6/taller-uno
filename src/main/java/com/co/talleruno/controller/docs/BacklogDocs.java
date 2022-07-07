package com.co.talleruno.controller.docs;

import com.co.talleruno.service.dto.BacklogInDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Backlog")
public interface BacklogDocs {

    @Operation(summary = "Create an order")
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "201",
                description = "Order created",
                content = {
                    @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
                }
            )
        }
    )
    ResponseEntity save(@RequestBody BacklogInDTO orderBody, BindingResult bindingResult);
}