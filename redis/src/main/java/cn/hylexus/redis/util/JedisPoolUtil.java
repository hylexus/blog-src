package cn.hylexus.redis.util;

import cn.hylexus.redis.Const;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {

	private static volatile JedisPool instance;

	private JedisPoolUtil() {
	}

	public static JedisPool getJedisPoolInstance() {
		if (instance == null) {
			synchronized (JedisPoolUtil.class) {
				JedisPoolConfig config = new JedisPoolConfig();
				config.setMaxIdle(20);
				config.setMaxWaitMillis(100 * 1000);
				config.setTestOnBorrow(true);
				instance = new JedisPool(config, Const.ip_master, Const.port_master);
			}
		}
		return instance;
	}

	@SuppressWarnings("deprecation")
	public static void release(JedisPool pool, Jedis jedis) {
		if(jedis!=null){
			pool.returnResourceObject(jedis);
		}
	}

}
