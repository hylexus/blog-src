package cn.hylexus.cloud.consumer.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"cn.hylexus.cloud.service"})
public class CloudDemoConsumerDeptApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDemoConsumerDeptApplication.class, args);
    }
}
