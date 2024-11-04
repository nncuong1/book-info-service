package io.nnc.bookinfoservice.util;

import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CacheUtilV2 {
  private static final long DEFAULT_NE_TIMEOUT = 30L;
  private static final TimeUnit DEFAULT_NE_TIME_UNIT = TimeUnit.SECONDS;

  private static final long DEFAULT_TIMEOUT = 10L;
  private static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.MINUTES;

  private static RedissonClient redisClient;

  @Autowired
  private RedissonClient tmpRedisClient;

  @PostConstruct
  public void init() {
    redisClient = tmpRedisClient;
  }

  private CacheUtilV2() {}

  private static RBucket<?> getBucket(String key) {
    return redisClient.getBucket(key);
  }

  public static <V> V get(String key) {
    return (V) getBucket(key).get();
  }

  public static <V> void set(String key, V value) {
    set(key, value, DEFAULT_TIMEOUT, DEFAULT_TIME_UNIT);
  }

  public static <V> void set(String key, V value, long duration, TimeUnit timeUnit) {
    getBucket(key).set(value, duration, timeUnit);
  }

  public static <V> V getAndDelete(String key) {
    return (V) getBucket(key).getAndDelete();
  }

  public static Boolean setIfNotExists(String key, String value) {
    return setIfNotExists(key, value, DEFAULT_NE_TIMEOUT, DEFAULT_NE_TIME_UNIT);
  }

  public static Boolean setIfNotExists(String key, String value, long duration) {
    return setIfNotExists(key, value, duration, DEFAULT_TIME_UNIT);
  }

  public static Boolean setIfNotExists(String key, String value, long duration, TimeUnit timeUnit) {
    return getBucket(key).trySet(value, duration, timeUnit);
  }
}
