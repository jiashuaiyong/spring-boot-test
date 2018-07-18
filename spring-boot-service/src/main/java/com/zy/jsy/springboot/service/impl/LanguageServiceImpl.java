package com.zy.jsy.springboot.service.impl;

import com.zy.jsy.springboot.service.LanguageService;
import com.zy.jsy.springbootcommon.contants.Constants;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Override
    public String queryLanguageCount() {
        Class language = Constants.LanguageType.class;
        //获取该类型声明的成员
        Field[] fields=language.getDeclaredFields();
        return String.valueOf(fields.length);
    }
}
