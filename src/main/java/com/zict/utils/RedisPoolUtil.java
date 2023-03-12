package com.zict.utils;

import org.springframework.beans.factory.annotation.Value;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPoolUtil {
	@Value("${spring.redis.host}")
	private static String host;
	@Value("${spring.redis.port}")
	private static int port;
	
	private static JedisPool pool;
	static {
		JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(5);
		jedisPoolConfig.setMaxIdle(1);
		
		pool =new JedisPool(jedisPoolConfig,"172.20.10.4",6379);
	}
	
	public static Jedis getJedis() {
		return pool.getResource();
	}
	
	public static void jedisClose(Jedis jedis) {
		jedis.close();
	}
}
