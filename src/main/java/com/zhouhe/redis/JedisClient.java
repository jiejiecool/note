package com.zhouhe.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisClient {
	
	private static JedisPool jedisPool = null;
	static{
		jedisPool = new JedisPool(new JedisPoolConfig(), "192.168.12.246", 6379, 10000, "JjFM8S0GLtT9E");
	}
	
	public static <T> T domain(RedisActionInterface<T> redisAction) {
		T result;
		try (Jedis jedis = jedisPool.getResource();){
			result = redisAction.operate(jedis);
		}
		return result;
	}
	
	public static void setValue(VoidFunction redisAction) {
		try (Jedis jedis = jedisPool.getResource();){
			 redisAction.set(jedis);
		}
	}
	
	public static void setValue(String key, String value) {
		//domain(jedis -> jedis.set(key, value));
		setValue(new VoidFunction() {
			@Override
			public void set(Jedis jedis) {
				jedis.set(key, value);
			}});
	}
	
	public static String getValue(String key) {
		return domain(jedis -> jedis.get(key));
	}
	
	@Test
	public void test() {
		System.out.println(JedisClient.getValue("taiji_user_admin"));
	}
}
