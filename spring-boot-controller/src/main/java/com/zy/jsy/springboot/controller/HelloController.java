package com.zy.jsy.springboot.controller;

import com.zy.jsy.springboot.service.LanguageService;
import com.zy.jsy.springboot.service.ValidateService;
import com.zy.jsy.springbootcommon.contants.Constants;
import com.zy.jsy.springbootcommon.exception.AppRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import req.UsernameReq;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * springBoot 测试控制器
 */
@RestController
public class HelloController {

    @Autowired
    private LanguageService languageServiceImpl;
    @Resource(name = "chineseLanguageService")
    private LanguageService chineseLanguageService;
    @Autowired
    private LanguageService englishLanguageService;
    @Autowired
    private HashMap<Integer, Integer> rewardMap;
    @Autowired
    private ArrayList<Integer> rewardList;


    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot";
    }

    /**
     * 各moudle之间的依赖
     *
     * @return
     */
    @RequestMapping("/language")
    public String commonMavenTest() {
        return Constants.LanguageType.Chinese + Constants.LanguageType.English;
    }

    /**
     * 注入service
     *
     * @return
     */
    @RequestMapping("/languageCount")
    public String languageCount() {
        return languageServiceImpl.queryLanguageCount();
    }

    /**
     * 获取xml中配置的bean
     *
     * @return
     */
    @RequestMapping("xmlTest")
    public String xmlTest() {
        return String.valueOf(rewardMap.get(1));
    }

    /**
     * 不在xml中配置，改由代码托管
     *
     * @return
     */
    @RequestMapping("beanTest")
    public List beanTest() {
        return rewardList;
    }

    /**
     * 自定义注解
     */
    @RequestMapping("userName")
    public String userName(String userName) {
        try {
            UsernameReq req = new UsernameReq();
            req.setUserName(userName);
            ValidateService.validate(req);
            return "参数正确";
        } catch (AppRuntimeException e) {
            return e.getErrorCode() + "   " + e.getErrorMessage();
        } catch (Exception e) {
            return "未捕获的异常";
        }
    }

    /**
     * switch表达式后面的数据类型只支持byte,short,char,int四种整形类型、枚举类型和java.lang.String类型(jdk1.7之后才支持)
     */
    @RequestMapping("switch")
    public String switchTest(String languageType) {
        String languageName;
        switch (languageType) {
            case "1":
                languageName = chineseLanguageService.getLanguage();
                break;
            case "2":
                languageName = englishLanguageService.getLanguage();
                break;
            default:
                languageName = "no";
                break;
        }
        return languageName;

    }

}
