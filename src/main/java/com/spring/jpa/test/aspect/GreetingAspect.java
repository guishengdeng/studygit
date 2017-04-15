package com.spring.jpa.test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

/**
 * GreetingAspect
 *
 * @author guisheng.deng
 * @date 2017年04月15日
 * @reviewer
 * @description
 * @see
 */
public class GreetingAspect {
    //@Around("execution(* com.spring.jpa.test.HelloImpl.*(..)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        before();
        Object result=joinPoint.proceed();
        after();
        return result;
    }
    private void before(){
      System.out.println("before");
    }
    private void after(){
        System.out.println("after");
    }
}