package cn.hylexus.cloud.consumer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hylexus
 * createdAt 2018/10/29
 **/
@Configuration
public class MyRibbonRule {

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
