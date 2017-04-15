package exampletest;

import com.spring.jpa.test.HelloImpl;
import com.spring.jpa.test.IApologize;
import com.spring.jpa.test.IHello;
import com.spring.jpa.test.ProxyHello;
import com.spring.jpa.test.proxy.DynamicProxy;
import com.spring.jpa.test.studyaop.GreetingAroundAdvice;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TestCase
 *
 * @author guisheng.deng
 * @date 2017年04月13日
 * @reviewer
 * @description
 * @see
 */
public class TestCase {
    @Test
    public void testResult(){
        ProxyHello proxyHello=new ProxyHello();
        proxyHello.say("张三");
    }
    @Test
    public void testProxy(){
        IHello hello=new HelloImpl();//目标对象
        DynamicProxy dynamicProxy=new DynamicProxy(hello);//动态代理对象
        //重构前：
        //IHello helloProxy=(IHello) Proxy.newProxyInstance(hello.getClass().getClassLoader(),hello.getClass().getInterfaces(),dynamicProxy);
        //代码重构后：
        IHello helloProxy=dynamicProxy.getProxyInstance();//通过动态代理工厂生成一个代理对象
        helloProxy.say("张三");
    }
    @Test
    public  void testAdvice(){
        //aop的原理也是基于jdk的动态代理机制
        ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.setTarget(new HelloImpl());//注入目标对象
      /*  proxyFactory.addAdvice(new GreetingBeforeAdvice());//添加前置增强
        proxyFactory.addAdvice(new GreetingAfterAdvice());//添加后置增强*/
         proxyFactory.addAdvice(new GreetingAroundAdvice());

        //从代理工厂中，获得代理对象
        IHello hello=(IHello)proxyFactory.getProxy();
        hello.say("beijing");
    }
    @Test
    public void testConfigAdvice(){
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        IHello hello=(IHello)context.getBean("greetingProxy");
        hello.say("jack");

    }
    @Test
    public void testIntroAdvice(){
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
       //注意转型为目标类，而非目标类所实现的接口？？？？
        HelloImpl helloImpl=(HelloImpl)context.getBean("greetingProxy");
        helloImpl.say("java ,to study it is not easy");
        //将目标类强行向上转型为IAologize类型,这是引入增强带来的新特性,即：“接口动态实现”的功能
        IApologize apologize=(IApologize)helloImpl;
        apologize.saySorry("jack");
    }
    @Test
    public void testAdvisor(){
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //注意转型为目标类，而非目标类所实现的接口？？？？
        IHello hello=(IHello)context.getBean("greetingProxy");
        hello.goodAfternoon("java hello world");
    }
    @Test
    public void testAspect(){
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //注意转型为目标类，而非目标类所实现的接口？？？？
        IHello hello=(IHello)context.getBean("helloImpl");
        hello.say("java hello world");
    }
}