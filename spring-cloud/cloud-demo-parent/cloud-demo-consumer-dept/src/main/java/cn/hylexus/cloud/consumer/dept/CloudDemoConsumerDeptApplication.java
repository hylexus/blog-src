package cn.hylexus.cloud.consumer.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"cn.hylexus.cloud"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CloudDemoConsumerDeptApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDemoConsumerDeptApplication.class, args);
    }
}
