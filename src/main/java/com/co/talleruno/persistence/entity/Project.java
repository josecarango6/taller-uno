package com.co.talleruno.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",updatable = false,nullable = false,unique = true)
    private Long id;

    @Column(name = "project_name")
    @NotEmpty(message = "El nombre del proyecto no puede estar vacio")
    private String projectName;

    @NotEmpty(message = "El identificador del proyecto no puede estar vacio")
    @Column(name = "project_identifier")
    private String projectIdentifier;

    @NotEmpty(message = "La descripcion no puede estar vacia")
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;


    @JoinColumn(name = "backlog")
    @OneToOne()
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
