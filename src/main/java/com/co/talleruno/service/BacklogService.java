package com.co.talleruno.service;

import com.co.talleruno.persistence.entity.Backlog;

import java.util.List;

public interface BacklogService {

    List<Backlog> findAll();
    Backlog findById(Long id);
    Backlog save(Backlog backlog);
    void delete(Backlog backlog);

}
