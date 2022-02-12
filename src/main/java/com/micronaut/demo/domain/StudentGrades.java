package com.micronaut.demo.domain;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Data;

@Introspected
@Data
@AllArgsConstructor
public class StudentGrades {

    int id;
    String name;
    String grade;
    int total;

}
