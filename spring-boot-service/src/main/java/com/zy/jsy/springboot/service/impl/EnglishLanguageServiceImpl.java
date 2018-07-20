package com.zy.jsy.springboot.service.impl;

import com.zy.jsy.springboot.service.LanguageService;
import org.springframework.stereotype.Service;

@Service("englishLanguageService")
public class EnglishLanguageServiceImpl implements LanguageService {
    @Override
    public String queryLanguageCount() {
        return null;
    }

    @Override
    public String getLanguage() {
        return "English-Language-Service";
    }
}
