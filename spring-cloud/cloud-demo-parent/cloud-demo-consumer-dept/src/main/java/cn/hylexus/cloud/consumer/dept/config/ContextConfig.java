package cn.hylexus.cloud.consumer.dept.config;

import cn.hylexus.cloud.service.FeignDeptServiceFallbackFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hylexus
 * createdAt 2018/10/21
 **/
@Configuration
public class ContextConfig {

    //TODO why? auto-configuration is not work ???
    @Bean
    public FeignDeptServiceFallbackFactory fallbackFactory(){
        return new FeignDeptServiceFallbackFactory();
    }
}
