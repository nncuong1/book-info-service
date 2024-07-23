package io.nnc.bookinfoservice.util;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CompletableFutureUtils {

  private static final long DEFAULT_TIMEOUT = 20L;
  private static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.SECONDS;

  public <T> List<T> getAllCompleted(
      List<CompletableFuture<T>> futuresList, long timeout, TimeUnit unit) {
    CompletableFuture<Void> allFuturesResult =
        CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]));
    try {
      allFuturesResult.get(timeout, unit);
    } catch (InterruptedException e) {
      log.error("CompletableFutureUtils", e);
      Thread.currentThread().interrupt();
    } catch (Exception e) {
      log.error("CompletableFutureUtils", e);
    }
    return futuresList.stream()
        .filter(future -> future.isDone() && !future.isCompletedExceptionally())
        .map(CompletableFuture::join)
        .collect(Collectors.<T>toList());
  }

  public <T> List<T> getAllCompleted(
      List<CompletableFuture<T>> futuresList, long... customTimeOut) {
    var timeOut = DEFAULT_TIMEOUT;
    if (Objects.nonNull(customTimeOut) && customTimeOut.length != 0) {
      timeOut = customTimeOut[0];
    }
    return getAllCompleted(futuresList, timeOut, DEFAULT_TIME_UNIT);
  }

  public <T> List<T> getAllCompleted(CompletableFuture<T> future, long... customTimeOut) {
    var timeOut = Objects.nonNull(customTimeOut) ? customTimeOut[0] : DEFAULT_TIMEOUT;
    List<CompletableFuture<T>> futuresList = Collections.singletonList(future);
    return getAllCompleted(futuresList, timeOut, DEFAULT_TIME_UNIT);
  }
}
