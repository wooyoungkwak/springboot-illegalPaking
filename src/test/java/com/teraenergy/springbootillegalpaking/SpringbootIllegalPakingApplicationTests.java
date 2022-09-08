package com.teraenergy.springbootillegalpaking;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootTest
//@EntityScan(basePackageClasses = {Jsr310JpaConverters.class}, basePackages = {"com.terenergy.springbootillegalpaking.model"})
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.teraenergy"}, excludeFilters = {@ComponentScan.Filter(SpringBootApplication.class)})
class SpringbootIllegalPakingApplicationTests {

    @Test
    void contextLoads() {
    }

}
