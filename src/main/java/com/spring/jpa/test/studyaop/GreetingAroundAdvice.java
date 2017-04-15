package com.spring.jpa.test.studyaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * GreetingAroundAdvice
 *
 * @author guisheng.deng
 * @date 2017年04月14日
 * @reviewer
 * @description
 * @see
 */
@Component
public class GreetingAroundAdvice implements MethodInterceptor {
    //@component （把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object result=methodInvocation.proceed();
        after();
        return result;
    }
    public void before(){
        System.out.println("before");
    }
    public void after(){
        System.out.println("after");
    }
}