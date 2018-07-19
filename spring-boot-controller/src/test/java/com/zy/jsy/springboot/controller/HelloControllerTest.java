package com.zy.jsy.springboot.controller;

import com.zy.jsy.springboot.service.LanguageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

    @Autowired
    private LanguageService languageService;
    @Test
    public void languageCount() {
        System.out.println("测试结果为："+languageService.queryLanguageCount());
    }
}