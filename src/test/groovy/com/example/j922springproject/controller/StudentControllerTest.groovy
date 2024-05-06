package com.example.j922springproject.controller

import com.example.j922springproject.model.dto.StudentDto
import com.example.j922springproject.model.exception.NotFoundException
import com.example.j922springproject.service.StudentService
import org.skyscreamer.jsonassert.JSONAssert
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import java.time.LocalDate

import static org.springframework.http.HttpStatus.NOT_FOUND

class StudentControllerTest extends Specification {
    MockMvc mockMvc
    private StudentService studentService

    void setup() {
        studentService = Mock()
        def studentController = new StudentController(studentService)
        mockMvc = MockMvcBuilders.standaloneSetup(studentController)
                .setControllerAdvice(new ErrorHandler())
                .build()
    }

    def "GetStudent 200"() {
        given:
        def id = 1L
        def url = "/v1/students/$id"

        def studentDto = new StudentDto(
                "Ramin",
                "Eliyev",
                LocalDate.of(2004, 10, 9),
                [1L]
        )

        def responseJson = '''
                    {
                      "name": "Ramin", 
                      "surname": "Eliyev", 
                      "dob": "2004-10-09",
                      "teacherIds": [
                         1
                      ]
                    }
        '''

        when:
        def res = mockMvc
                .perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andReturn().response

        then:
        1 * studentService.getStudent(id) >> studentDto

        res.status == 200
        JSONAssert.assertEquals(responseJson, res.contentAsString, false)
    }

    def "GetStudent 404"() {
        given:
        def id = 1L
        def url = "/v1/students/$id"

        when:
        def res = mockMvc
                .perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andReturn().response

        then:
        1 * studentService.getStudent(id) >> {
            throw new NotFoundException("STUDENT_NOT_FOUND")
        }

        res.status == NOT_FOUND.value//404
        res.contentAsString == '''{"code":"STUDENT_NOT_FOUND"}'''
    }
}
