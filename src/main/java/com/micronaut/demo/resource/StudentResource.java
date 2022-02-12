package com.micronaut.demo.resource;

import com.micronaut.demo.model.Student;
import com.micronaut.demo.service.StudentService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;

@Controller(value = "/student")
@Slf4j
public class StudentResource {

    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @Get("/{id}")
    public Student getStudentScoresById(@PathVariable @NotNull Integer id){

        return studentService.getStudentScoresById(id);

    }
}
