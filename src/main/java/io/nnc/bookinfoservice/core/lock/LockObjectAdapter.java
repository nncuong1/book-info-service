package io.nnc.bookinfoservice.core.lock;

public interface LockObjectAdapter<K> {
  void lock(K k);

  K releaseLock(K k);
}
