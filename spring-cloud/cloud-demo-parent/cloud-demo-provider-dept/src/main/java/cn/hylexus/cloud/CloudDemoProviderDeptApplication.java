package cn.hylexus.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hylexus
 * createdAt 2018/10/21
 **/
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class CloudDemoProviderDeptApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudDemoProviderDeptApplication.class, args);
    }
}
