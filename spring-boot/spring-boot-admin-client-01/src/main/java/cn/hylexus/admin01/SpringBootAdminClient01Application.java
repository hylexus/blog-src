package cn.hylexus.admin01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class SpringBootAdminClient01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminClient01Application.class, args);
    }
}
