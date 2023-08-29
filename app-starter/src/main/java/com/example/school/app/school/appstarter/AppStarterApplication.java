package com.example.school.app.school.appstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.example.school.app.school"})
@EntityScan("com.example.school.app.school.model")
@EnableJpaRepositories("com.example.school.app.school.repository")
@SpringBootApplication
public class AppStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppStarterApplication.class, args);
    }

}
