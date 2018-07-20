package com.zy.jsy.springboot.controller;

import com.zy.jsy.springboot.service.LanguageService;
import com.zy.jsy.springboot.service.ValidateService;
import com.zy.jsy.springbootcommon.exception.AppRuntimeException;
import com.zy.jsy.springbootcommon.utils.DV;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import req.UsernameReq;

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


    @DV(nullable = false,minLength = 2,maxLength = 10)
    private static String userName = "1";
    @Test
    public void annotation(){


        try {
            ValidateService.validate(userName);
            System.out.println(userName);
        } catch (AppRuntimeException e) {
            System.out.println(e.getErrorMessage());
        }catch (Exception e) {
            System.out.println(e);
        }
    }



}