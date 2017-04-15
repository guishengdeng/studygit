package com.spring.jpa.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * DynamicProxy
 *
 * @author guisheng.deng
 * @date 2017年04月13日
 * @reviewer
 * @description
 * @see
 */
public class DynamicProxy implements InvocationHandler {
    private Object target;//目标对象
    public DynamicProxy(Object target){
        this.target=target;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result=method.invoke(target,args);

       /* Class<?>[] parameterTypes = method.getParameterTypes();
        for (Class<?> clas : parameterTypes) {
            String parameterName = clas.getName();
            System.out.println("参数名称:" + parameterName);
        }*/

        System.out.println("method name"+method.getName());
        after();
        return result;
    }
    private void before(){
        System.out.println("before");
    }
    private void after(){
        System.out.println("after");
    }
    public  DynamicProxy(){

    }
    public <T> T getProxyInstance(){
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}