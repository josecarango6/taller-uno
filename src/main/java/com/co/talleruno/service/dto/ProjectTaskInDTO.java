package com.co.talleruno.service.dto;

import com.co.talleruno.persistence.entity.Backlog;
import com.co.talleruno.persistence.entity.ProjectStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectTaskInDTO {
    @NotEmpty(message = "El nombre de la tarea no puede estar vacio")
    private String name;

    @NotEmpty(message = "El resumen no puede estar vacio")
    private String summary;

    private String acceptanceCriteria;
    private ProjectStatus projectStatus;

    @Min(value = 1, message = "La prioridad debe de ser de 1 a 5")
    @Max(value = 5, message = "La prioridad debe de ser de 1 a 5")
    private Integer priority;

    @Min(value = 1, message = "Las horas deben de ser mayor o igual a 1 y no superiores a 8")
    @Max(value = 8, message = "Las horas deben de ser mayor o igual a 1 y no superiores a 8")
    private Double hours;

    private LocalDateTime endDate;

    @NotEmpty(message = "El identificador del proyecto no puede estar vacio")
    @Size(min=5, max=7, message = "El identificador del proyecto debe de ser de 5 a 7 caracteres")
    private String projectIdentifier;

}
