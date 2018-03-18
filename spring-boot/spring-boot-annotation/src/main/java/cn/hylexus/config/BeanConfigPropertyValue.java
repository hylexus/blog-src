package cn.hylexus.config;

import cn.hylexus.entity.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author hylexus
 * createdAt 2018/3/17
 **/
@Configuration
@PropertySource("classpath:application.properties")
public class BeanConfigPropertyValue {

    @Value("${user.default-name}")
    private String defaultName;

    @Value("#{1+1}")
    private Integer id;

    @Bean
    public UserEntity userEntity() {
        return new UserEntity(id, defaultName);
    }

}
