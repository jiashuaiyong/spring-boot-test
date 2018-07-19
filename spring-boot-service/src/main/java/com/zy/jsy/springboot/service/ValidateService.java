package com.zy.jsy.springboot.service;


import com.zy.jsy.springbootcommon.exception.AppRuntimeException;
import com.zy.jsy.springbootcommon.utils.DV;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ValidateService {

    private static DV dv;

    public ValidateService() {
        super();
    }

    //解析入口
    public static void validate(Object object) throws Exception {
        //获取object的类型
        Class<? extends Object> classzz = object.getClass();
        //获取该类型声明的成员
        Field[] fields = classzz.getDeclaredFields();
        //遍历属性
        for (Field field : fields) {
            //对于private私有化的成员变量，通过setAccessible来修改访问权限
            field.setAccessible(true);
            //开始对变量检验
            validateField(field,object);
            //重新设置为私有权限
            field.setAccessible(false);
        }
    }

    //单一属性的校验
    public static void validateField(Field field, Object object) throws Exception {

        //对象描述
        String description;
        Object value;

        //获取对象的成员注解
        if (field.isAnnotationPresent(DV.class)){
            dv = field.getAnnotation(DV.class);
        }
/*        Annotation[] annotations = field.getDeclaredAnnotations();
        if (null != annotations){
            dv = (DV) annotations[0];
        }*/
        value = field.get(object);

        if (null == dv){
            return;
        }

        description = StringUtils.isEmpty(dv.description()) ? field.getName() : dv.description();

        if (!dv.nullable()){
            if (null == value || StringUtils.isEmpty(value.toString())){
                throw new AppRuntimeException("E001",description+"不能为空");
            }
        }

        if (value.toString().length()>dv.maxLength() && dv.maxLength() != 0){
            throw new AppRuntimeException("E002",description+"长度不能超过"+dv.maxLength());
        }

        if (value.toString().length() < dv.minLength() && dv.minLength() != 0){
             throw new AppRuntimeException("E003",description+"长度不能小于" + dv.minLength());
        }

        if(!StringUtils.isEmpty(dv.regexExpression())){
            if(value.toString().matches(dv.regexExpression())){
                throw new AppRuntimeException("E004",description+"格式不正确");
            }
        }

    }


}
