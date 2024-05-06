package com.example.j922springproject.dao.repository;

import com.example.j922springproject.dao.entity.EmployeeEntity;
import com.example.j922springproject.dao.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<EmployeeEntity, Long> {
}
