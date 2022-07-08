package com.co.talleruno;

import com.co.talleruno.persistence.entity.Project;
import com.co.talleruno.persistence.repository.ProjectRepository;
import com.co.talleruno.service.ProjectService;
import com.co.talleruno.service.ProjectServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class ProjectServiceMockTest {

    @Mock
    private ProjectService projectService;
    private ProjectRepository projectRepository;

    @BeforeEach
    public void begin(){

        MockitoAnnotations.openMocks(this);
        projectService = new ProjectServiceImpl(projectRepository);

        Project project = Project.builder()
                .id(1L)
                .projectName("projecto test 1")
                .projectIdentifier("123")
                .descripcion("descripcion test")
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.of(2022,07,10,11,00))
                .build();
        //projectService.save(project);

        Mockito.when(projectRepository.findById(1L))
                .thenReturn(Optional.of(project));

    }

    @Disabled
    @Test
    public void when_findById_return_project(){
        Project product = projectService.findById(1L);
        Assertions.assertThat(product.getProjectName()).isEqualTo("projecto test 1");
    }

}
