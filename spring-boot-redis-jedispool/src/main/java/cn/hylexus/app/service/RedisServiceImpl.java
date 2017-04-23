package cn.hylexus.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisServiceImpl implements RedisService {

	// 此处直接注入即可
	@Autowired
	private JedisPool jedisPool;

	@Override
	public String get(String key) {
		Jedis jedis = this.jedisPool.getResource();
		String ret;
		try {
			ret = jedis.get(key);
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return ret;
	}

	@Override
	public boolean set(String key, String val) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			return "OK".equals(jedis.set(key, val));
		} finally {
			if (jedis != null)
				jedis.close();
		}
	}

}
