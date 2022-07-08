package com.co.talleruno;


import com.co.talleruno.persistence.entity.Project;
import com.co.talleruno.persistence.repository.ProjectRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Disabled
@DataJpaTest
public class ProjectRepositoryMockTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void test_assessAmountOfProjects(){

        Project project = Project.builder()
                .projectName("projecto test 1")
                .projectIdentifier("123")
                .descripcion("descripcion test")
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.of(2022,07,10,11,00))
                .build();

        Project projectTwo = Project.builder()
                .projectName("projecto test 2")
                .projectIdentifier("456")
                .descripcion("descripcion test 2")
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.of(2022,07,10,11,00))
                .build();

        projectRepository.save(project);
        projectRepository.save(projectTwo);

        List<Project> projects = projectRepository.findAll();
        Assertions.assertThat(projects.size()).isEqualTo(2);


    }
}
