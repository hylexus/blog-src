package cn.hylexus.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudDemoEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDemoEurekaApplication.class, args);
    }
}
