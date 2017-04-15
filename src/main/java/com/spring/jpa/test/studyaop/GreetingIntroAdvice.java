package com.spring.jpa.test.studyaop;

import com.spring.jpa.test.IApologize;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * GreetingIntroAdvice
 *
 * @author guisheng.deng
 * @date 2017年04月14日
 * @reviewer
 * @description
 * @see
 */
@Component
public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements IApologize {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        return super.invoke(mi);
    }

    public void saySorry(String name) {
        System.out.println("sorry!"+name);
    }
}