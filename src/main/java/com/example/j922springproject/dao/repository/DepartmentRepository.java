package com.example.j922springproject.dao.repository;

import com.example.j922springproject.dao.entity.DepartmentEntity;
import com.example.j922springproject.dao.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository
        extends JpaRepository<DepartmentEntity, Long> {
}
