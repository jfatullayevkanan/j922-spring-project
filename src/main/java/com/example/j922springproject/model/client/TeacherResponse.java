package com.example.j922springproject.model.client;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class TeacherResponse {
    private String fullName;
    private BigDecimal salary;
}
