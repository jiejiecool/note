package com.zhouhe.redis;

import redis.clients.jedis.Jedis;

@FunctionalInterface
public interface RedisActionInterface<T> {
	public T operate(Jedis jedis);
}
