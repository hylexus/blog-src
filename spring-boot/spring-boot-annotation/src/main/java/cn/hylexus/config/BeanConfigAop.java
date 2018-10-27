package cn.hylexus.config;

import cn.hylexus.aop.MathCalculatorLogAspect;
import cn.hylexus.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author hylexus
 * createdAt 2018/3/19
 **/

@Configuration
@EnableAspectJAutoProxy
public class BeanConfigAop {

    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    @Bean
    public MathCalculatorLogAspect logAspect() {
        return new MathCalculatorLogAspect();
    }
}
