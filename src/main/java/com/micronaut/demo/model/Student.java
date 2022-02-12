package com.micronaut.demo.model;

import com.micronaut.demo.domain.Subject;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Introspected
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Student {

    int id;
    String name;
    String grade;
    int total;
    List<Subject> subjects;

}
