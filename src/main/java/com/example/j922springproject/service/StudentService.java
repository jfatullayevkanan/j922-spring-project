package com.example.j922springproject.service;

import com.example.j922springproject.client.TexnoeraClient;
import com.example.j922springproject.dao.entity.StudentEntity;
import com.example.j922springproject.dao.repository.StudentRepository;
import com.example.j922springproject.dao.repository.TeacherRepository;
import com.example.j922springproject.mapper.StudentMapper;
import com.example.j922springproject.model.dto.StudentDto;
import com.example.j922springproject.model.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    private final AsyncService asyncService;

    private final TexnoeraClient texnoeraClient;

    public StudentService(StudentRepository studentRepository,
                          TeacherRepository teacherRepository,
                          AsyncService asyncService,
                          TexnoeraClient texnoeraClient) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.asyncService = asyncService;
        this.texnoeraClient = texnoeraClient;
    }

    public List<StudentEntity> getStudents(String nameFilter, String lang) {
        System.out.println("nameFilter: " + nameFilter + "lang: " + lang);
        return studentRepository.findAll();
    }

    public StudentDto getStudent(Long id) {
        log.info("ActionLog.getStudent.start with id: {}", id);

        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(() -> {
            log.error("ActionLog.getStudent.error student not found with id: {}", id);
            throw new NotFoundException("STUDENT_NOT_FOUND");
        });

        var studentDto = StudentMapper.mapEntityToDto(studentEntity);
        studentDto.setLessons(null);

        log.info("ActionLog.getStudent.end with id: {}", id);
        return studentDto;
    }

    public void addStudent(StudentDto studentDto) {
        log.info("ActionLog.addStudent.start");

        System.out.println(studentDto);
        var teachers = teacherRepository.findByIdIn(studentDto.getTeacherIds());

//        asyncService.saveData();

        log.info("ActionLog.addStudent.info saving student data");

        var entity = StudentEntity.builder()
                .name(studentDto.getName())
                .surname(studentDto.getSurname())
                .dob(studentDto.getDob())
                .teacherEntities(teachers)
                .build();

        studentRepository.save(entity);

        log.info("ActionLog.addStudent.end");
    }
}
