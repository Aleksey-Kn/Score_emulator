package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class FirstSpringProgectApplication {
    private static final Logger logger = Logger.getLogger(FirstSpringProgectApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringProgectApplication.class, args);
    }
}
