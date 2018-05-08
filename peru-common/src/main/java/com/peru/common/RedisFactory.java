package com.peru.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by roger.lu on 2018/3/11.
 */
public class RedisFactory {

  private static final Logger LOGGER = LoggerFactory.getLogger(RedisFactory.class);

  @Autowired
  private JedisPool jedisPool;

  public Jedis getInstance() {
    return jedisPool.getResource();
  }

  public void release (Jedis jedis){
    jedis.close();
  }

  public void shutdown(){
    jedisPool.destroy();
  }

}
