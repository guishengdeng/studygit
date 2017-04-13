package com.spring.jpa.exception;

/**
 * BookNotFoundException
 *
 * @author guisheng.deng
 * @date 2017年04月12日
 * @reviewer
 * @description:自定义测试类，用作测试spring的事务管理机制。
 * @see
 */
public class BookNotFoundException extends Exception{
    public BookNotFoundException(){
        super();
    }
    public BookNotFoundException(String message){
        super(message);
    }
}