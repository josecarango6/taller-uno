package com.co.talleruno.persistence.repository;

import com.co.talleruno.persistence.entity.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BacklogRepository extends JpaRepository<Backlog, Long> {

}
