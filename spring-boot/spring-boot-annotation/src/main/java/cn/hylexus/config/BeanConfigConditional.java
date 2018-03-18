package cn.hylexus.config;

import cn.hylexus.config.condition.MacOsCondition;
import cn.hylexus.config.condition.WindowsCondition;
import cn.hylexus.config.slector.BeanRegistry;
import cn.hylexus.config.slector.ImportSelectorImpl;
import cn.hylexus.entity.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;

/**
 * @author hylexus
 * createdAt 2018/3/11
 **/
@Configuration
// 使用无参构造快速创建一个bean，加入容器中，bean的id是包名+类名
@Import({ArrayList.class, ImportSelectorImpl.class, BeanRegistry.class})
public class BeanConfigConditional {

    @Conditional({MacOsCondition.class})
    @Bean
    public UserEntity user06() {
        return new UserEntity(6, "梅野石");
    }

    @Bean
    @Conditional({WindowsCondition.class})
    public UserEntity user07() {
        return new UserEntity(7, "风君子");
    }

}
