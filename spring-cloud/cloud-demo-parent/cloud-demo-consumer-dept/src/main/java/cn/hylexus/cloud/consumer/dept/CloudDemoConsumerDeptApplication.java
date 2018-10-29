package cn.hylexus.cloud.consumer.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//@RibbonClient(name = "CLOUD-DEMO-PROVIDER-DEPT", configuration = MyRoundRobinRule.class)
//@RibbonClient(name = "CLOUD-DEMO-PROVIDER-DEPT", configuration = MyRibbonRule.class)
public class CloudDemoConsumerDeptApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDemoConsumerDeptApplication.class, args);
    }
}
