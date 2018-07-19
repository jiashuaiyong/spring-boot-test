package com.zy.jsy.springboot.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class BeanConfigService {


    @Bean
    public ArrayList getRewardList(){
        ArrayList<Integer> rewardList = new ArrayList<Integer>();
        rewardList.add(1);
        rewardList.add(2);
        return rewardList;
    }
}
