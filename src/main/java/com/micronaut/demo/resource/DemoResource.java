package com.micronaut.demo.resource;


import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;

@Controller
@Slf4j
public class DemoResource {

    @Get
    public String getGreetings(@QueryValue @NotNull String name){

        log.info("sending greetings to {}",name);

        return "Hello %s from demo application".formatted(name);
    }
}
