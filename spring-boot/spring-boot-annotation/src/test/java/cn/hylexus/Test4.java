package cn.hylexus;

import cn.hylexus.config.ConfigTest;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hylexus
 * createdAt 2018/4/5
 **/
public class Test4 {

    @Test
    public void test3() {
        int n = 1;
        while (n < 125) {
            n <<= 1;
        }

        System.out.println(n);
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ConfigTest.class);

        System.out.println(context instanceof BeanFactory);
    }

    @Test
    public void test2() {
        new Child().doSomething();
    }

    static class Parent {
        synchronized void doSomething() {
        }
    }

    static class Child extends Parent {

        @Override
        synchronized void doSomething() {
            super.doSomething();
        }
    }
}
