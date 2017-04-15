package com.spring.jpa.test.studyaop;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * GreetingThrowAdvice
 *
 * @author guisheng.deng
 * @date 2017年04月14日
 * @reviewer
 * @description
 * @see
 */
@Component
public class GreetingThrowAdvice implements ThrowsAdvice {
      public void  afterThrowing(Method method,Object[] args,Object target,Exception e){
          System.out.println("Throw Exception");
          System.out.println("target class"+target.getClass().getName());
          System.out.println("method name"+method.getName());
          System.out.println("exception message"+e.getMessage());
          System.out.println("-------------------");
      }
}