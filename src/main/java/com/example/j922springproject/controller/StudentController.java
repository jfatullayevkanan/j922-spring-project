package com.example.j922springproject.controller;

import com.example.j922springproject.dao.entity.StudentEntity;
import com.example.j922springproject.model.dto.StudentDto;
import com.example.j922springproject.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v1/students")
@Api(description = "Student operation controller")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @ApiOperation("Get all students")
    @PreAuthorize("@permissionService.hasPermission('ROLE_USER')")
    public List<StudentEntity> getStudents(
            @RequestParam(value = "nameFilter", required = false) String nameFilter,
            @RequestHeader String lang) {
        return studentService.getStudents(nameFilter, lang);
    }

    @GetMapping("/{id}")
    @PreAuthorize("@permissionService.hasPermission({'ROLE_USER', 'ROLE_ADMIN'})")
    public StudentDto getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @PreAuthorize("@permissionService.hasPermission('ROLE_ADMIN')")
    public void addStudent(@RequestBody @Valid StudentDto studentDto) {
        studentService.addStudent(studentDto);
    }
}
/*
Polymorphism, Encapsulation, Inheritance, Abstraction, abstract vs interface, final, equals and hashCode
PUT vs PATCH
Algorithm complexity O(n)
Sorting algorithms
Data structure
stack vs queue
SOLID
JAVA 8
Functional interface
LAZY injection
Primary and qualifier

Bəhmən ** + ? + * + - * * + - - * = 85
Rüfət - * + ? * * - - + * * - - * = 70
Osman + * + ? * * - - - + * - - + = 65
Həsən - + * ? * * - - ? - * - - ? = 45
Ramin - - * ? * + - - - - * - - - = 32
Kənan - - * ? * * - - - - * - - ? = 30

5 10 15 20 ... 5000
 */



/*
Create new project and new database for following tasks
Adding controller, service, dao(entity, repository) and model packages
Add entity for creating new table(without query)
Writing following api's using Hibernate, JPA

1. Add new api for getting all data from this table
2. Add new api for inserting new row to table
3. Add new api for getting table data for id
4. Add new api for editing all data by id
5. Add new api for delete data by id

 */
