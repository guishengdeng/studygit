package com.spring.jpa.test;

/**
 * ProxyHello
 *
 * @author guisheng.deng
 * @date 2017年04月13日
 * @reviewer
 * @description
 * @see
 */
public class ProxyHello implements IHello {
    private IHello hello;
    public ProxyHello(){
        hello=new HelloImpl();
    }
    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    public void goodMorning(String name) {

    }

    public void goodAfternoon(String name) {

    }

    private void before(){
        System.out.println("before");
    }
    private void after(){
        System.out.println("after");
    }
}