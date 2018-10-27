package cn.hylexus.cloud.consumer.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudDemoConsumerDeptApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDemoConsumerDeptApplication.class, args);
    }
}
