package com.example.j922springproject.model.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class DepartmentDto {
    private Long id;
    private String departmentName;
    private LocalDate createdDate;
}
