package io.nnc.bookinfoservice.core.lock;

import io.nnc.bookinfoservice.exception.ConcurrentProcessingException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import lombok.Setter;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class LockAdapter<K> implements LockObjectAdapter<K> {
  @Setter private String lockBucketKey;

  @Setter private long ttl;

  @Setter private String type;

  @Setter(onMethod = @__({@Autowired}))
  private RedissonClient client;

  private RMapCache<K, K> processingBucket;

  @Override
  public void lock(K k) throws ConcurrentProcessingException {
    K result = this.processingBucket.putIfAbsent(k, k, ttl, TimeUnit.SECONDS);

    if (Objects.nonNull(result)) {
      throw new ConcurrentProcessingException(type + " " + k + " is processing by others");
    }
  }

  @Override
  public K releaseLock(K k) {
    return this.processingBucket.remove(k);
  }

  protected void initBucket() {
    this.processingBucket = client.getMapCache(lockBucketKey, new StringCodec());
  }
}
