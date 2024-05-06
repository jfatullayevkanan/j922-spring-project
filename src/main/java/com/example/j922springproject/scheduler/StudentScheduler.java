package com.example.j922springproject.scheduler;

import com.example.j922springproject.model.dto.StudentDto;
import com.example.j922springproject.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@Slf4j
public class StudentScheduler {
    private final StudentService studentService;

    public StudentScheduler(StudentService studentService) {
        this.studentService = studentService;
    }

//    @Scheduled(fixedDelay = 100000)
//    @SchedulerLock(name = "addNewStudent", lockAtMostFor = "PT5M", lockAtLeastFor = "PT1M")
    void addNewStudent() {
        Random random = new Random();
        StudentDto studentDto = StudentDto.builder()
                .name("Name" + random.nextInt())
                .surname("Surname " + random.nextInt())
                .teacherIds(List.of(1L))
                .build();

        studentService.addStudent(studentDto);
    }
}
