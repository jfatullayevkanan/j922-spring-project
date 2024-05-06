package com.example.j922springproject.model.dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
public class CompanyCarDto {
    private Long id;
    private String licenseNumber;
    private short modelYear;
    private String model;
}
