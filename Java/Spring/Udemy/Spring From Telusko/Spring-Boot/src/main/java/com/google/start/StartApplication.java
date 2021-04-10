package com.google.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StartApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StartApplication.class, args);

        Alien alien = context.getBean(Alien.class);
        alien.code();
    }

}
