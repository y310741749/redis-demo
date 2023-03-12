package com.zict.controller;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * Jedis原始操作
 */
public class RedisNativeController {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println(jedis.ping());
//        Long lpush = jedis.lpush("mylist", "jedis");
//        String test = jedis.set("test", "1");
//        jedis.expire("test", 10);
//        System.out.println("test:" + test);
//        System.out.println("ttl1:" + jedis.ttl("test"));
//        System.out.println(jedis.exists("mylist"));
//        long millis = 2000;
//        try {
//            Thread.sleep(2000);
//        } catch (Exception e) {
//            System.out.println("产生异常" + e.getMessage());
//        }
        jedis.select(1);
        jedis.set("money","100");
        jedis.set("out","0");
        jedis.watch("money");
        Transaction multi = jedis.multi();
        try {
            multi.decrBy("money",20);
            multi.incrBy("out",20);
//            multi.set("t3","t3");
//            int i = 1/0;
////            multi.set("t1","t1");
//            multi.incr("t1");
//            multi.set("t2","t2");
            multi.exec();
        }catch (Exception e){
            multi.discard();
            System.out.println(e.getMessage());
        }finally {
            System.out.println("money:"+jedis.get("money"));
            System.out.println("out:"+jedis.get("out"));
//            System.out.println("t3:"+jedis.get("t3"));
            jedis.close();
        }
//        System.out.println("ttl2:" + jedis.ttl("test"));


    }
}
