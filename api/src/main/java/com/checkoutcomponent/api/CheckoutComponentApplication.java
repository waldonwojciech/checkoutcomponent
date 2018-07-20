package com.checkoutcomponent.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.checkoutcomponent.application.infrastructure.service",
        "com.checkoutcomponent.api.infrastructure.rest"})
@EntityScan(basePackages = "com.checkoutcomponent.domain.model")
@EnableJpaRepositories(basePackages = "com.checkoutcomponent.domain.repository")
public class CheckoutComponentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckoutComponentApplication.class, args);
    }
}
