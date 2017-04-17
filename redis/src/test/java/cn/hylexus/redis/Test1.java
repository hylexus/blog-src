package cn.hylexus.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class Test1 {

	@Test
	public void test1() {
		try {
			Jedis jedis = new Jedis(Const.ip_master, Const.port_master);
			String ret = jedis.ping();
			System.out.println(ret);
			jedis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSet(){
		
	}
}
