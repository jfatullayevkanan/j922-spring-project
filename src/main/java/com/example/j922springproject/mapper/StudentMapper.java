package com.example.j922springproject.mapper;

import com.example.j922springproject.dao.entity.StudentEntity;
import com.example.j922springproject.model.dto.StudentDto;

public class StudentMapper {
    public static StudentDto mapEntityToDto(StudentEntity entity) {
        return StudentDto.builder()
                .name(entity.getName())
                .surname(entity.getSurname())
                .dob(entity.getDob())
                .build();
    }
}
