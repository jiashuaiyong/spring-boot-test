package com.zy.jsy.springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages="com.zy.jsy")
@ImportResource(locations={"classpath:application-config.xml"})
public class SpringBootControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootControllerApplication.class, args);
    }
}
