package com.micronaut.demo.domain;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Data;

@Introspected
@Data
@AllArgsConstructor
public class Subject {

    String subject;
    int score;
}
