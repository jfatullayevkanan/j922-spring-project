package com.example.j922springproject.service;

import com.example.j922springproject.dao.repository.DepartmentRepository;
import com.example.j922springproject.mapper.DepartmentMapper;
import com.example.j922springproject.model.dto.DepartmentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDto> getDepartments() {
        log.info("ActionLog.getDepartments.start");

        var response  = DepartmentMapper.INSTANCE.mapEntitiesToDtoList(
                departmentRepository.findAll());

        log.error("ActionLog.getDepartments.end");
        return response;
    }
}
