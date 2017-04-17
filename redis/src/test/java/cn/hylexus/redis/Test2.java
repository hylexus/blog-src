package cn.hylexus.redis;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class Test2 {

	private Jedis jedis;

	@Before
	public void before() {
		this.jedis = new Jedis(Const.ip_master, Const.port_master);
	}

	@After
	public void after() {
		if (this.jedis != null)
			this.jedis.close();
	}

	@Test
	public void testSetGet() {
		this.jedis.flushAll();
		this.jedis.set("username", "tom");
		this.jedis.set("age", "141");
		this.jedis.keys("*").stream().forEach(k -> {
			System.out.println(k + "-->" + this.jedis.get(k));
		});
	}

	@Test
	public void testTransaction1() {
		Transaction transaction = this.jedis.multi();
		transaction.flushAll();
		transaction.set("k_name", "apache");
		transaction.set("k_age", "1122");
		List<Object> ret = transaction.exec();

		ret.stream().forEach(System.out::println);

		System.out.println("==========");

		this.jedis.mget("k_name", "k_age").stream().forEach(System.out::println);
	}

	@Test
	public void testTransaction2() {
		this.jedis.flushAll();
		Transaction transaction = this.jedis.multi();
		try {
			transaction.set("k_name", "apache");
			transaction.set("k_age", "1122");
			System.out.println(1 / 0);// 模拟异常
			transaction.exec();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			String string = transaction.discard();
			System.out.println("discard:" + string);
		}

		this.jedis.mget("k_name", "k_age").stream().forEach(System.out::println);
	}

	public void pay(int val) {
		// 假设balance为100元
		final String balanceKey = "balance";
		final String debtKey = "debt";

		this.jedis.set(balanceKey, "100");
		this.jedis.set(debtKey, "0");
		this.jedis.watch(balanceKey);
		// this.jedis.set(balanceKey, "123");//modify
		int balance = Integer.parseInt(this.jedis.get(balanceKey));
		if (balance < val) {
			this.jedis.unwatch();
			throw new RuntimeException("余额不足:balance=" + balance + ",val=" + val);
		}

		Transaction transaction = this.jedis.multi();
		transaction.decrBy(balanceKey, val);
		transaction.incrBy(debtKey, val);
		transaction.exec();
		this.jedis.unwatch();

		this.jedis.mget(balanceKey, debtKey).forEach(System.out::println);
	}

	@Test
	public void testTransaction() {
		try {
			this.pay(10);
			this.pay(101);
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
