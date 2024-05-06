package com.example.j922springproject.service;

import com.example.j922springproject.dao.entity.EmployeeEntity;
import com.example.j922springproject.dao.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeEntity> getEmployees() {
        return employeeRepository.findAll();
    }
}
