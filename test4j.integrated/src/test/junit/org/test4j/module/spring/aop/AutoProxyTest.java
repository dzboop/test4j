package org.test4j.module.spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.test4j.junit.JTester;
import org.test4j.module.spring.testedbeans.aop.Bird;
import org.test4j.module.spring.testedbeans.aop.Cat;

public class AutoProxyTest implements JTester {
    @Test
    public void testAutoProxyTest() {
        String[] paths = { "org/jtester/module/spring/testedbeans/aop/animal-aop.xml" };
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        Cat tiger = (Cat) ctx.getBean("tiger");
        tiger.hasHotBlood();
        Bird albatross = (Bird) ctx.getBean("albatross");
        albatross.hasBeak();
    }

    @Test
    public void testAutoProxyTest2() {
        String[] paths = { "org/jtester/module/spring/testedbeans/aop/animal-aop2.xml" };
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        Cat tiger = (Cat) ctx.getBean("tiger");
        tiger.hasHotBlood();
        Bird albatross = (Bird) ctx.getBean("albatross");
        albatross.hasBeak();
    }
}