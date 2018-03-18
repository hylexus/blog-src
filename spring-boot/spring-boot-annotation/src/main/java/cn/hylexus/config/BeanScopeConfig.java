package cn.hylexus.config;

import cn.hylexus.entity.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @author hylexus
 * createdAt 2018/3/11
 **/
@Configuration
public class BeanScopeConfig {

    @Scope(scopeName = SCOPE_PROTOTYPE)
    @Bean(name = "user04")
    UserEntity user() {
        return new UserEntity(1, "叶心怡");
    }


    @Bean("user05")
    @Lazy
    UserEntity user2(){
        return new UserEntity(1, "玉无双");
    }

}
