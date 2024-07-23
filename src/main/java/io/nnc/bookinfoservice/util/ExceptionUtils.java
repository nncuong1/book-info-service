package io.nnc.bookinfoservice.util;

import java.util.function.Function;

public class ExceptionUtils {

  public static void retryOnException(Runnable runnable, int maxRetries, long timeSeed) {
    retryOnException(runnable, e -> true, maxRetries, timeSeed);
  }

  public static <E extends RuntimeException> void retryOnException(
      Runnable runnable, Function<E, Boolean> retry, int maxRetries, long timeSeed) {
    int count = 0;
    while (count <= maxRetries) {
      try {
        Thread.sleep(count * timeSeed);
        runnable.run();
        return;
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      } catch (RuntimeException e) {
        E exception = (E) e;
        if (!retry.apply(exception)) throw e;
        if (++count >= maxRetries) throw e;
      }
    }
  }
}
