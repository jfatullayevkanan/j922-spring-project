package com.example.j922springproject.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class DepartmentRequest {
    private String departmentName;
    private LocalDate createdDate;
}
