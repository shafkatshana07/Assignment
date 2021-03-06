package com.shana.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class AssignmentApplication {

    public static void main(String[] args) {

        SpringApplication.run(AssignmentApplication.class, args);

        System.out.println("Spring Boot Application Started !!!");
    }


}
