package cn.hylexus.cloud.consumer.dept.config;

import cn.hylexus.cloud.consumer.dept.lb.rule.MyRoundRobinRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule loadBalanceRule(){
        return new MyRoundRobinRule();
    }
}
