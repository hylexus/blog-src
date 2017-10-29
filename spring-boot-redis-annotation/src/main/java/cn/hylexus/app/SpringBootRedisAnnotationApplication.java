package cn.hylexus.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author hylexus
 **/
@EnableCaching
@SpringBootApplication
public class SpringBootRedisAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisAnnotationApplication.class, args);
    }
}
