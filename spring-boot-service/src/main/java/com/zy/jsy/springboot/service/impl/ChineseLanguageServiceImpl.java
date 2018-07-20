package com.zy.jsy.springboot.service.impl;

import com.zy.jsy.springboot.service.LanguageService;
import org.springframework.stereotype.Service;

@Service("chineseLanguageService")
public class ChineseLanguageServiceImpl implements LanguageService {
    @Override
    public String queryLanguageCount() {
        return null;
    }

    @Override
    public String getLanguage() {
        return "汉语-处理器";
    }
}
