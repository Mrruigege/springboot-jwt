package com.rui.springbootjwt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  ElementType.METHOD 在方法上增加此注解可以跳过Token的认证
 *  ElementType.TYPE  接口、类、枚举、注解
 *  RetentionPolicy.RUNTIME 这种类型的Annotations将被JVM保留，运行时也存在
 *
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}
