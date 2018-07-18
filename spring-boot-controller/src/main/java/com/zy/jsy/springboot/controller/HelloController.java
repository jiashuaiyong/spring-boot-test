package com.zy.jsy.springboot.controller;

import com.zy.jsy.springboot.service.LanguageService;
import com.zy.jsy.springbootcommon.contants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * springBoot 测试控制器
 */
@RestController
public class HelloController {

    @Autowired
    private LanguageService languageService;
    @Autowired
    private HashMap<Integer,Integer> rewardMap;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Spring Boot";
    }
    @RequestMapping("/language")
    public String commonMavenTest(){
        return Constants.LanguageType.Chinese+Constants.LanguageType.English;
    }

    @RequestMapping("/languageCount")
    public String languageCount(){
        return languageService.queryLanguageCount();
    }

    @RequestMapping("xmlTest")
    public String xmlTest(){
        return String.valueOf(rewardMap.get(1));
    }

}
