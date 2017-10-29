package cn.hylexus.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Configuration
public class Config {

    //    @Bean("keyGenerator-02")
    public KeyGenerator getKeyGenerator() {
        return (Object target, Method method, Object... params) -> {
            final String prefix = target.getClass().getName() + "." + method.getName() + "_";

            return prefix + Arrays.stream(params)//
                    .filter(Objects::nonNull)
                    .filter(e -> {
                        final CacheItemConfig annotation = e.getClass().getDeclaredAnnotation(CacheItemConfig.class);
                        return annotation == null || annotation.valid();
                    })
                    .map(Object::toString)
                    .collect(Collectors.joining("_"));
        };
    }


    @Bean("myRedisCacheManager")
    public CacheManager redisCacheManager(@Autowired RedisTemplate redisTemplate) {
        // 替换默认的 JdkSerializationRedisSerializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        final List<String> cacheNames = Arrays.asList("demo-03", "demo-04");
        final ExtendedRedisCacheManager manager = new ExtendedRedisCacheManager(redisTemplate, cacheNames);
        manager.setDefaultExpiration(30L);// 30 seconds
        manager.setExpireSeparator('#');
        return manager;
    }
}
