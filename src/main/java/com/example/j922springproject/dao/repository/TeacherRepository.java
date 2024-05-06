package com.example.j922springproject.dao.repository;

import com.example.j922springproject.dao.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository
        extends JpaRepository<TeacherEntity, Long> {

    List<TeacherEntity> findByIdIn(List<Long> ids);
}
