package com.teraenergy.springbootillegalpaking;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

//@SpringBootTest
//@EntityScan(basePackageClasses = {Jsr310JpaConverters.class}, basePackages = {"com.terenergy.springbootillegalpaking.model"})
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.teraenergy"}, excludeFilters = {@ComponentScan.Filter(SpringBootApplication.class)})
@EntityScan(
        basePackageClasses = {Jsr310JpaConverters.class},
        basePackages = {"com.teraenergy"}
)
public class ApplicationTests {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTests.class, args);
    }

}
