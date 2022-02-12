package com.micronaut.demo.service;

import com.micronaut.demo.model.Student;
import com.micronaut.demo.repository.StudentRepository;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentScoresById(int id){

        var grades = studentRepository.getStudentGrades(id);

        var subjects = studentRepository.getSubjectScores(id);

        return Student.builder()
                .id(grades.getId())
                .name(grades.getName())
                .grade(grades.getGrade())
                .total(grades.getTotal())
                .subjects(subjects)
                .build();

    }
}
