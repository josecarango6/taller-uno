package com.co.talleruno.service.dto;

import com.co.talleruno.persistence.entity.Backlog;
import com.co.talleruno.persistence.entity.ProjectStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectTaskInDTO {
    private String name;
    private String summary;
    private String acceptanceCriteria;
    private ProjectStatus projectStatus;
    private Integer priority;
    private Double hours;
    private LocalDateTime endDate;
    private String projectIdentifier;

}
