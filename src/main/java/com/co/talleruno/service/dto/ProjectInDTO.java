package com.co.talleruno.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectInDTO {

    private String projectName;
    private String projectIdentifier;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
