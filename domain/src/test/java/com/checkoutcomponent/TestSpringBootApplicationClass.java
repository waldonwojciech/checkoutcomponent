package com.checkoutcomponent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.checkoutcomponent.model")
@EnableJpaRepositories("com.checkoutcomponent.repository")
@EnableScheduling
public class TestSpringBootApplicationClass {

    public static void main(String[] args) {
        SpringApplication.run(TestSpringBootApplicationClass.class, args);
    }
}
