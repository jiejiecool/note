package com.zhouhe.redis;

import redis.clients.jedis.Jedis;

public interface VoidFunction {
	public void set(Jedis jedis);
}
