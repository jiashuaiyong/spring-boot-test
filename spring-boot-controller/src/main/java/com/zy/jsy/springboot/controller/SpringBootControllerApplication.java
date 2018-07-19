package com.zy.jsy.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages="com.zy.jsy")
@ImportResource(locations={"classpath:application-config.xml"})
public class SpringBootControllerApplication {

    private static final Logger logger  = LoggerFactory.getLogger(SpringBootControllerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootControllerApplication.class, args);
        logger.info("******************** spring boot project run ********************");
    }
}
