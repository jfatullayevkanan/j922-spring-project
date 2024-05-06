package com.example.j922springproject.model.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class EmployeeDto {
    private Long id;

    private String name;

    private String surname;

    private String address;

    private CompanyCarDto companyCar;
    private DepartmentDto department;
}
