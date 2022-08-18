package com.vipindubey.springrestjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestJpaApplication {

    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/");
        SpringApplication.run(SpringRestJpaApplication.class, args);
    }

}
