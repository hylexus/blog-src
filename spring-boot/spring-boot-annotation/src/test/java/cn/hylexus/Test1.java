package cn.hylexus;

import cn.hylexus.config.*;
import cn.hylexus.entity.UserEntity;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author hylexus
 * createdAt 2018/3/11
 **/
public class Test1 {

    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
        UserEntity user = context.getBean(UserEntity.class);
        System.out.println(user);
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Object user = context.getBean("user");
        System.out.println(user);

        Arrays.stream(context.getBeanNamesForType(UserEntity.class)).forEach(System.out::println);
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanCustomerConfig.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Test
    public void test5() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanScopeConfig.class);
        Object user1 = context.getBean("user04");
        Object user2 = context.getBean("user04");
        System.out.println(user1 == user2);

        System.out.println(context.getBean("user05"));
    }


    @Test
    public void test06() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfigConditional.class);

        context.getBeansOfType(UserEntity.class)
                .forEach((k, v) -> {
                    System.out.println(k + "-->" + v);
                });
        System.out.println(context.getEnvironment().getProperty("os.name"));

        System.out.println(">>>>>><<<<<<<<");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Test
    public void test07() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfigFactoryBean.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        Object bean = context.getBean("userFactoryBean");
        System.out.println(bean.getClass().getName());
        Object beanOriginal = context.getBean("&userFactoryBean");
        System.out.println(beanOriginal.getClass());
    }
}
