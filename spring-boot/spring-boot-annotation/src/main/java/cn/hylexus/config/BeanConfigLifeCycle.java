package cn.hylexus.config;

import cn.hylexus.entity.MyDataSource;
import cn.hylexus.entity.MyDataSource2;
import cn.hylexus.entity.MyDataSource3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author hylexus
 * createdAt 2018/3/17
 **/
@Configuration
@ComponentScan(basePackages = "cn.hylexus.config")
public class BeanConfigLifeCycle {


    @Bean(initMethod = "init", destroyMethod = "destroy")
    public MyDataSource dataSource() {
        return new MyDataSource();
    }

    @Bean
    public MyDataSource2 dataSource2() {
        return new MyDataSource2();
    }

    @Bean
    public MyDataSource3 dataSource3() {
        return new MyDataSource3();
    }
}
