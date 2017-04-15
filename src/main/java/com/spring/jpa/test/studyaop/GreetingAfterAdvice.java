package com.spring.jpa.test.studyaop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * GreetingAfterAdvice
 *
 * @author guisheng.deng
 * @date 2017年04月14日
 * @reviewer
 * @description：后置增强类
 * @see：也可以写一个类，让该类实现AfterReturningAdvice和MethodBeforeAdvice两个接口
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("after");
    }
}