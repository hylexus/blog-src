package cn.hylexus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaRegistry01Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRegistry01Application.class, args);
	}
}
