package de.leuphana.jmstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer

public class JmsTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmsTestApplication.class, args);
    }

}
