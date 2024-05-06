package com.example.j922springproject.model.request;

import com.example.j922springproject.model.dto.DepartmentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
public class StudentRequestTest {
    private String name;
    private String surname;
    private LocalDate dob;
    private DepartmentDto departmentDto;
}
