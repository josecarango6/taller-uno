package com.co.talleruno.mapper;

import com.co.talleruno.persistence.entity.Backlog;
import com.co.talleruno.service.dto.BacklogInDTO;
import org.springframework.stereotype.Component;

@Component
public class BacklogInDtoToBacklog implements IMapper<BacklogInDTO, Backlog>{

    @Override
    public Backlog map(BacklogInDTO in) {
        Backlog backlog = new Backlog();
        backlog.setProjectIdentifier(in.getProjectIdentifier());
//        backlog.setProject(in.getProject());
        //backlog.setProjectTask(in.getProjectTask());
        return backlog;
    }
}
