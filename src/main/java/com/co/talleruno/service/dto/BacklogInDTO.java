package com.co.talleruno.service.dto;

import com.co.talleruno.persistence.entity.Project;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BacklogInDTO {

    @NotEmpty(message = "El identificador del proyecto no puede estar vacio")
    @Size(min=5, max=7, message = "El identificador del proyecto debe de ser de 5 a 7 caracteres")
    private String projectIdentifier;
}
