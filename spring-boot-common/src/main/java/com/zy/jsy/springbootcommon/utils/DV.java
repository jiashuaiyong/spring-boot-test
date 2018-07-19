package com.zy.jsy.springbootcommon.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据验证
 * Created by jiashuaiyong on 2018/07/19.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface DV {

    //是否可以为空，true 可以，false 不可以
    boolean nullable() default false;

    //字段最大长度
    int maxLength() default 0;

    //字段最小长度
    int minLength() default 0;

    //字段描述
    String description() default "";

    //自定义正则验证
    String regexExpression() default "";

}
