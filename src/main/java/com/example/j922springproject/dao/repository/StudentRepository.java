package com.example.j922springproject.dao.repository;

import com.example.j922springproject.dao.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository
        extends JpaRepository<StudentEntity, Long> {


    List<StudentEntity> findByName(String name);
}
