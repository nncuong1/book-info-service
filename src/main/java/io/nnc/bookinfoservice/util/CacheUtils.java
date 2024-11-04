package io.nnc.bookinfoservice.util;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

public class CacheUtils {
    private static final long DEFAULT_NE_TIMEOUT = 30l;
    private static final TimeUnit DEFAULT_NE_TIME_UNIT = TimeUnit.SECONDS;

    private static final long DEFAULT_TIMEOUT = 10l;
    private static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.MINUTES;

    private static RedissonClient redisClient;

    @Autowired
    private RedissonClient tmpRedisClient;

    @PostConstruct
    public void init() {
        redisClient = tmpRedisClient;
    }

    private CacheUtils() {
    }

    private static RBucket getBucket(String key) {
        RBucket bucket = redisClient.getBucket(key);
        return bucket;
    }

    public static <V> V get(String key) {
        RBucket<V> bucket = getBucket(key);
        return bucket.get();
    }

    public static <V> void set(String key, V value) {
        getBucket(key).set(value, DEFAULT_TIMEOUT, DEFAULT_TIME_UNIT);
    }

    public static <V> void set(String key, V value, long time, TimeUnit timeUnit) {
        getBucket(key).set(value, time, timeUnit);
    }

    public static <V> V getAndDelete(String key) {
        return (V) getBucket(key).getAndDelete();
    }

    public static Boolean setIfNotExists(String key, String value) {
        return getBucket(key).trySet(value, DEFAULT_NE_TIMEOUT, DEFAULT_NE_TIME_UNIT);
    }

    public static Boolean setIfNotExists(String key, String value, long secondsTime) {
        return getBucket(key).trySet(value, secondsTime, DEFAULT_TIME_UNIT);
    }

    public static Boolean setIfNotExists(String key, String value, long secondsTime, TimeUnit timeUnit) {
        return getBucket(key).trySet(value, secondsTime, timeUnit);
    }
}
