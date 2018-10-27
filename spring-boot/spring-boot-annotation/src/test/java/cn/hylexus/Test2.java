package cn.hylexus;

import cn.hylexus.aop.MathCalculator;
import cn.hylexus.config.BeanConfigAop;
import cn.hylexus.config.BeanConfigLifeCycle;
import cn.hylexus.config.BeanConfigPropertyValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author hylexus
 * createdAt 2018/3/17
 **/
public class Test2 {

    private AnnotationConfigApplicationContext getContext(Class<?> cls) {
        return new AnnotationConfigApplicationContext(cls);
    }

    private void printBeanNames(ApplicationContext context) {
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = this.getContext(BeanConfigLifeCycle.class);
        printBeanNames(context);
        context.close();
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = this.getContext(BeanConfigPropertyValue.class);
        Object bean = context.getBean("userEntity");
        System.out.println(bean);
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = this.getContext(BeanConfigAop.class);
        MathCalculator bean = context.getBean(MathCalculator.class);
        bean.div(2, 2);
    }

}
