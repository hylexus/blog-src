package cn.hylexus.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.util.StringUtils;

import java.util.Collection;

public class ExtendedRedisCacheManager extends RedisCacheManager {

    private static final Logger logger = LoggerFactory.getLogger(ExtendedRedisCacheManager.class);
    private char expireSeparator = '#';
    private String defaultCacheName;

    public ExtendedRedisCacheManager(RedisOperations redisOperations, Collection<String> cacheNames) {
        super(redisOperations, cacheNames);
    }


    public char getExpireSeparator() {
        return expireSeparator;
    }

    public void setExpireSeparator(char expireSeparator) {
        this.expireSeparator = expireSeparator;
    }

    public String getDefaultCacheName() {
        return defaultCacheName;
    }

    public void setDefaultCacheName(String defaultCacheName) {
        this.defaultCacheName = defaultCacheName;
    }

    @Override
    public Cache getCache(String name) {

        // 通过名称获取
        // 这个"名称"可能是包含失效时间的名称,所以可能获取不到
        RedisCache cache = (RedisCache) super.getCache(name);
        if (cache != null) {
            return cache;
        }

        // 获取分隔符
        final int index = name.lastIndexOf(getExpireSeparator());
        // 没有分隔符,还是以初始名称去获取,结果还是获取不到的,直接返回null
        if (index < 0) {
            return null;
        }
        // 获取真正的CacheName
        String cacheName = name.substring(0, index);

        // 支持省略CacheName的写法,此时的CacheName就是默认的
        if (StringUtils.isEmpty(cacheName)) {
            cacheName = getDefaultCacheName();
        }

        // 还是获取不到??? ==> return null;
        cache = (RedisCache) super.getCache(cacheName);
        if (cache == null) {
            return null;
        }

        final Integer expiration = getExpiration(name, index);
        if (expiration == null || expiration < 0) {
            logger.warn("解析expire失败,使用CacheManager级别默认失效时间");
            return cache;
        }

        return new RedisCache(cacheName, (isUsePrefix() ? getCachePrefix().prefix(cacheName) : null), getRedisOperations(), expiration);
    }

    private Integer getExpiration(final String name, final int separatorIndex) {
        Integer expiration = null;
        String expirationAsString = name.substring(separatorIndex + 1);
        try {
            expiration = Integer.parseInt(expirationAsString);
        } catch (NumberFormatException ex) {
            logger.error(String.format("解析失效时间失败: '%s'", name), ex);
        }
        return expiration;
    }
}
