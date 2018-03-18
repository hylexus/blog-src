package cn.hylexus.config;

import cn.hylexus.factory.UserFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hylexus
 * createdAt 2018/3/17
 **/
@Configuration
public class BeanConfigFactoryBean {

    @Bean
    public UserFactoryBean userFactoryBean() {
        return new UserFactoryBean();
    }
}
