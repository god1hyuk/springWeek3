package com.sparta.springweek3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringWeek3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringWeek3Application.class, args);
    }

}
