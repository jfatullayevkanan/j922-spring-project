package com.example.j922springproject.service

import com.example.j922springproject.dao.entity.StudentEntity
import com.example.j922springproject.dao.repository.StudentRepository
import com.example.j922springproject.dao.repository.TeacherRepository
import com.example.j922springproject.model.exception.NotFoundException
import io.github.benas.randombeans.EnhancedRandomBuilder
import spock.lang.Specification

class StudentServiceTest extends Specification {
    private random = EnhancedRandomBuilder.aNewEnhancedRandom()

    private StudentRepository studentRepository
    private TeacherRepository teacherRepository
    private StudentService studentService

    void setup() {
        studentRepository = Mock()
        teacherRepository = Mock()
        studentService =
                new StudentService(studentRepository,
                        teacherRepository, asyncService, texnoeraClient)
    }

    def "GetStudents success"() {
        given:
        def nameFilter = "test"
        def lang = "az"

        def entityList = [
                random.nextObject(StudentEntity),
                random.nextObject(StudentEntity)
        ]

        when:
        def result = studentService.getStudents(nameFilter, lang)

        then:
        1 * studentRepository.findAll() >> entityList

        result[0].name == entityList[0].name
        result[0].surname == entityList[0].surname
        result[1].name == entityList[1].name
    }

    def "GetStudent success"() {
        given:
        def id = 100L
        def entity = random.nextObject(StudentEntity)
        entity.name = "Osman"

        when:
        def dto = studentService.getStudent(id)

        then:
        1 * studentRepository.findById(id) >> Optional.of(entity)

        dto.name == "Osman"
        dto.surname == entity.surname
        dto.dob == entity.dob
    }

    def "GetStudent student not found"() {
        given:
        def id = 100L

        when:
        studentService.getStudent(id)

        then:
        1 * studentRepository.findById(id) >> Optional.empty()

        def exception = thrown(NotFoundException)
        exception.message == "STUDENT_NOT_FOUND"
    }
}
