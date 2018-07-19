package com.zy.jsy.springboot.controller;

import com.zy.jsy.springboot.service.LanguageService;
import com.zy.jsy.springbootcommon.contants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * springBoot 测试控制器
 */
@RestController
public class HelloController {

    @Autowired
    private LanguageService languageService;
    @Autowired
    private HashMap<Integer,Integer> rewardMap;
    @Autowired
    private ArrayList<Integer> rewardList;


    @RequestMapping("/hello")
    public String hello(){
        return "Hello Spring Boot";
    }

    /**
     * 各moudle之间的依赖
     * @return
     */
    @RequestMapping("/language")
    public String commonMavenTest(){
        return Constants.LanguageType.Chinese+Constants.LanguageType.English;
    }

    /**
     * 注入service
     * @return
     */
    @RequestMapping("/languageCount")
    public String languageCount(){
        return languageService.queryLanguageCount();
    }

    /**
     * 获取xml中配置的bean
     * @return
     */
    @RequestMapping("xmlTest")
    public String xmlTest(){
        return String.valueOf(rewardMap.get(1));
    }

    /**
     * 不在xml中配置，改由代码托管
     * @return
     */
    @RequestMapping("beanTest")
    public List beanTest(){
        return rewardList;
    }

}
