package com.example.j922springproject.model.request;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
public class StudentRequest {
    private String name;
    private String surname;
    private LocalDate dob;
    private List<Long> teacherIds;
}
