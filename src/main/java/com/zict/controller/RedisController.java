package com.zict.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zict.utils.RedisPoolUtil;

import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @RequestMapping("/testRedisCon")
    public String testRedisCon() {
        Jedis jedis = RedisPoolUtil.getJedis();
        jedis.set("name", "杨鹏");
        String name = RedisPoolUtil.getJedis().get("name");
        RedisPoolUtil.jedisClose(jedis);
        return name;
    }

}
