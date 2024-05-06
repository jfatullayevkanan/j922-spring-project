package com.example.j922springproject.service;

import com.example.j922springproject.dao.entity.StudentEntity;
import com.example.j922springproject.dao.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class AsyncService {
    private final StudentRepository studentRepository;

    public AsyncService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Async
    public void saveData() {
        log.info("ActionLog.saveData.start: {}", LocalDateTime.now());

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        log.info("ActionLog.saveData.info: {}", LocalDateTime.now());

        StudentEntity entity = StudentEntity
                .builder()
                .name("Test1235")
                .surname("Testov12345")
                .build();

        studentRepository.save(entity);

        log.info("ActionLog.saveData.end: {}", LocalDateTime.now());
    }
}
