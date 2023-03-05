package com.mock.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties
@EnableTransactionManagement
@EnableJpaAuditing
public class MockAssessmentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockAssessmentApiApplication.class, args);
    }

}
