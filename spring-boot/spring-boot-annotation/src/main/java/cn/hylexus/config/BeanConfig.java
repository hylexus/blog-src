package cn.hylexus.config;

import cn.hylexus.entity.UserEntity;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Repository;

/**
 * @author hylexus
 * createdAt 2018/3/11
 **/
@Configuration
@ComponentScans({
        @ComponentScan(
                value = "cn.hylexus",
                excludeFilters = {
                        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Repository.class})
                }
        )
})
public class BeanConfig {

    @Bean
    public UserEntity user() {
        UserEntity user = new UserEntity();
        user.setEmail("hylexus@163.com");
        user.setName("陆云");
        user.setId(2);
        return user;
    }

    @Bean
    public UserEntity user2() {
        UserEntity user = new UserEntity();
        user.setEmail("hylexus@163.com");
        user.setName("苍月");
        user.setId(2);
        return user;
    }

    @Bean(name = "user00003")
    public UserEntity user3() {
        UserEntity user = new UserEntity();
        user.setEmail("hylexus@163.com");
        user.setName("百灵");
        user.setId(2);
        return user;
    }
}
