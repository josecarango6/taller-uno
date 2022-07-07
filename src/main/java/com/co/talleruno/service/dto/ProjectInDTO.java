package com.co.talleruno.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectInDTO {
    @NotEmpty(message = "El nombre del proyecto no puede estar vacio")
    private String projectName;

    @NotEmpty(message = "El identificador del proyecto no puede estar vacio")
    @Size(min=5, max=7, message = "El identificador del proyecto debe de ser de 5 a 7 caracteres")
    private String projectIdentifier;

    @NotEmpty(message = "La descripcion del proyecto no puede estar vacia")
    private String description;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
