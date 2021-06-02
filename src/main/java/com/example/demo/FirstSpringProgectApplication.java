package com.example.demo;

import com.example.demo.dataManagers.Desktop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class FirstSpringProgectApplication {
    private static final Logger logger = Logger.getLogger(FirstSpringProgectApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringProgectApplication.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Desktop desktop = context.getBean(Desktop.class);
        desktop.init(3, "M", 0, 10, "monoblock");
        context.getBean(DataBaseAssistant.class).add(desktop);
    }
}
