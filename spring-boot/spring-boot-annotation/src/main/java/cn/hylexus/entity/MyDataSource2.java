package cn.hylexus.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author hylexus
 * createdAt 2018/3/17
 **/
public class MyDataSource2 implements InitializingBean, DisposableBean {
    public MyDataSource2() {
        System.out.println("MyDataSource2 Constructor ...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MyDataSource2 destroy ...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyDataSource2 init ...");
    }
}
