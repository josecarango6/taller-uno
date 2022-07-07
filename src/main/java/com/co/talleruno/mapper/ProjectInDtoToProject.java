package com.co.talleruno.mapper;

import com.co.talleruno.persistence.entity.Project;
import com.co.talleruno.service.dto.ProjectInDTO;
import org.springframework.stereotype.Component;

@Component
public class ProjectInDtoToProject implements IMapper<ProjectInDTO, Project> {

    @Override
    public Project map(ProjectInDTO in) {
        return Project.builder()
            .projectName(in.getProjectName())
            .projectIdentifier(in.getProjectIdentifier())
            .descripcion(in.getDescription())
            .startDate(in.getStartDate())
            .endDate(in.getEndDate())
            .build();
    }
}
