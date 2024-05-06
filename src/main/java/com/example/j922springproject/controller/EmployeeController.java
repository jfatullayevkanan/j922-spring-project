package com.example.j922springproject.controller;

import com.example.j922springproject.dao.entity.EmployeeEntity;
import com.example.j922springproject.service.EmployeeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @PreAuthorize("@permissionService.hasPermission('ROLE_ADMIN')")
    public List<EmployeeEntity> getEmployees() {
        return employeeService.getEmployees();
    }
}


/*

new tasks
1. Liquibase ilə yeni bir table yaratmaq foreign key mütləq olsun
Mapper logging, LIQUIBASE istifadə etməklə
many to many əlaqə qurun
response və request modeldə dto istifadə edin
entity to dto və əksi olan logicalı işləri mapper layerdə yeni classlar yaradıb edin
1. Get all data
2. Add new row
3. Edit existing data by id

Cascade types, LAZY/EAGER, orphanRemoval
Add Error handler and handle all exceptions(at least not found exception)

1. Use swagger for all apis and request models
2. in post and put requests use field validation and handle exceptions
 */





/*
Salam mən Kənan Fətullayev 4 ilə yaxındır ki back end proqramlaşdırma üzrə çalışıram
və 1 ildən artıqdır ki, TexnoEra academy-də JAVA back end üzrə
müəllim olaraq işləyirəm
 */

/*
Javaya nece başladız?
Proqramlaşdırma ilə tanışlığım univeritest illərində oldu və o dönəmlərdə C/C++ öyrəndim.
Sonradan bazarda Java proqramladşırma dilinə olan tələbatı gördüm və Java öyrənməyə başladım
 */

/*
Proqramlaşdırma dili nədir?
Necə ki, xarici vətəndaşlarla danışmaq üçün xarici dil öyərnirik analoji olaraq
kompüterlərlə danışmaq üçün proqramlaşdırma dillərindən istifadə edirik.
Günümüzdə ən çox istifadə olunan proqramlaşdırma dillərindən biri Javadır
Biz java ilə web, mobile, desktop applicationlar yarada bilərik.
 */

/*
Java öyrənmək üçün hansı biliklər lazımdır?
Başlıca olaraq riyaziyyat, məntiq və səbr,
Əlavə olaraq bizim dildə oxumaq üçün materiallar az olduğundan
texniki səviyyədə ingilis və ya rus dili bilikləri lazımdır
 */

/*
Java öyrənərək hansı iş imkanlarını əldə edirsiz?
Java back end öyrənərək siz həm daxili,həm də remote olaraq xarici bazardan bir çox
iş imkanları əldə edə bilərsiz

 */
/*
Siz də Java proqramlaşdırma dilini öyrənmək istəyirsizsə öyrənməyin
Siz də Java proqramlaşdırma dilini öyrənmək istəyirsizsə
mənə və ya Texnoera academiyaya yaza bilərsiz
*/
