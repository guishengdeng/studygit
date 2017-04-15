package com.spring.jpa.test.studyaop;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * GreetingBeforeAdvice
 *
 * @author guisheng.deng
 * @date 2017年04月14日
 * @reviewer
 * @description:前置增强类
 * @see
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("before");
    }
}