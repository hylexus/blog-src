package cn.hylexus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaRegistry00Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRegistry00Application.class, args);
	}
}
