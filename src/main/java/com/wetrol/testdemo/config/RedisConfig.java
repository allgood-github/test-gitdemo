package com.wetrol.testdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private Integer port;

    @Value("${spring.redis.password}")
    private String password;


    @Bean
    public JedisPool jedis(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(300);//最大空闲数
        jedisPoolConfig.setMaxWaitMillis(2000);
        jedisPoolConfig.setBlockWhenExhausted(true);//// 连接耗尽时是否阻塞, false报异常,true阻塞直到超时, 默认true
        jedisPoolConfig.setJmxEnabled(true); // 是否启用pool的jmx管理功能, 默认true

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, 2000, password);
        return jedisPool;
    }


}
