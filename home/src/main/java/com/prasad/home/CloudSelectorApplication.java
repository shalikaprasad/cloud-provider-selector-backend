package com.prasad.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.prasad.models.response"})
@ComponentScan(basePackages = {"com.prasad"})
public class CloudSelectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudSelectorApplication.class, args);
    }
}
