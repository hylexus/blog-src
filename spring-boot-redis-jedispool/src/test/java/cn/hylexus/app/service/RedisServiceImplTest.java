package cn.hylexus.app.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.hylexus.app.SpringBootRedisJedispoolApplicationTests;

public class RedisServiceImplTest extends SpringBootRedisJedispoolApplicationTests {

	@Autowired
	private RedisService redisService;

	@Test
	public void testGet() {
		// test set
		boolean status = this.redisService.set("foo", "bar");
		Assert.assertTrue(status);

		// test get
		String str = this.redisService.get("foo");
		Assert.assertEquals("bar", str);
	}

}
