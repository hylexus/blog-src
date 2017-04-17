package cn.hylexus.redis.util;

import org.junit.Assert;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisPoolUtilTest {

	@Test
	public void testGetJedisPoolInstance() {
		JedisPool pool1 = JedisPoolUtil.getJedisPoolInstance();
		JedisPool pool2 = JedisPoolUtil.getJedisPoolInstance();
		Assert.assertTrue(pool1 == pool2);
	}

	@Test
	public void test1() {
		Jedis jedis = null;

		try {
			jedis = JedisPoolUtil.getJedisPoolInstance().getResource();
			jedis.flushAll();
			jedis.set("k1", "v1");
			System.out.println(jedis.get("k1"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JedisPoolUtil.release(JedisPoolUtil.getJedisPoolInstance(), jedis);
		}

	}

}
