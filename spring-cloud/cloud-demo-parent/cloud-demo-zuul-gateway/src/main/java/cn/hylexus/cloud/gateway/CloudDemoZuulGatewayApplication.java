package cn.hylexus.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class CloudDemoZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDemoZuulGatewayApplication.class, args);
    }
}
