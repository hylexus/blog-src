package cn.hylexus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UserService01Application {

	
	public static void main(String[] args) {
		SpringApplication.run(UserService01Application.class, args);
	}
}
