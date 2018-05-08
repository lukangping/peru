package com.peru.common;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

/**
 * Created by roger.lu on 2018/3/11.
 */
public class RedisHelper {

  @Autowired
  private RedisFactory redisFactory;

  public String get(String key){

    Jedis jedis = redisFactory.getInstance();
    try {
      return jedis.get(key);
    } finally {
      if (null != jedis) {
        redisFactory.release(jedis);
      }
    }

  }

  public Long incr(String key) {
    Jedis jedis = redisFactory.getInstance();
    try {
      return jedis.incr(key);
    } finally {
      if(null!=jedis){
        redisFactory.release(jedis);
      }
    }
  }

  public void set(String key, String value, int seconds){
    Jedis jedis = redisFactory.getInstance();
    try {
      jedis.set(key, value);
      jedis.expire(key, seconds);
    } finally {
      if(null!=jedis){
        redisFactory.release(jedis);
      }
    }
  }

}
