package cn.hylexus.cloud.consumer.dept.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author hylexus
 * createdAt 2018/10/21
 **/
@Configuration
public class ContextConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
