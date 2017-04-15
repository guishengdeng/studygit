package com.spring.jpa.test;

import com.spring.jpa.exception.BookNotFoundException;
import org.springframework.stereotype.Component;

/**
 * HelloImpl
 *
 * @author guisheng.deng
 * @date 2017年04月13日
 * @reviewer
 * @description
 * @see
 */
@Component
public class HelloImpl implements IHello {
    //@component （把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
    public void say(String name) {
        System.out.println("hello\t"+name);
   /*     throw new RuntimeException("error");*/
    }
    public void  goodMorning(String name){
         System.out.println("good morning"+name);
    }
    public void goodAfternoon(String name){
        System.out.println("good afternoon" +name);
    }

}