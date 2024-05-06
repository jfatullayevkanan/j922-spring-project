package com.example.j922springproject.model.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LessonResponse {
    private String lessonName;
    private TeacherResponse teacherDto;
}
