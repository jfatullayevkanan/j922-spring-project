package com.example.j922springproject.model.dto;

import com.example.j922springproject.model.client.LessonResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@ApiModel("Model for adding student")
public class StudentDto {
    @NotBlank(message = "NAME_CAN_NOT_BE_EMPTY")
    @ApiModelProperty("Name of student which user enter")
    private String name;

    @NotBlank(message = "SURNAME_CAN_NOT_BE_EMPTY")
    private String surname;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private List<Long> teacherIds;

    private List<LessonResponse> lessons;
}
