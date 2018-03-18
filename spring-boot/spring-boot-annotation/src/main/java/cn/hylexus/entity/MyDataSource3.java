package cn.hylexus.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author hylexus
 * createdAt 2018/3/17
 **/
public class MyDataSource3 {

    public MyDataSource3() {
        System.out.println("MyDataSource3 Constructor ...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("MyDataSource3 PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("MyDataSource3 PreDestroy");
    }
}
