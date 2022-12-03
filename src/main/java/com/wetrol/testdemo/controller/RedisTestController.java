package com.wetrol.testdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("/api/redis")
public class RedisTestController {

    @Autowired
    JedisPool jedisPool;

    @GetMapping("/jedis")
    public String testJedis(String key,
                            @RequestParam(required = false) String value) {
        Jedis jedis = null;
        jedis = jedisPool.getResource();
        if (StringUtils.hasLength(value)) {
            jedis.set(key, value);
        }
        return "成功获取redis ==>" + "{" + key + ":" + jedis.get(key) + "}";
    }

}
