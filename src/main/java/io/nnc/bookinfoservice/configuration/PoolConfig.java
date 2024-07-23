package io.nnc.bookinfoservice.configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class PoolConfig {

  private static final int WAIT_TIME = 2;
  private static final int SERVICE_TIME = 1;

  @Bean("threadPoolTaskExecutor")
  public Executor getAsyncExecutor() throws UnknownHostException {
    int poolSize = Runtime.getRuntime().availableProcessors() * (1 + WAIT_TIME / SERVICE_TIME);
    return buildTaskExecutor("Book-Async-", poolSize);
  }

  public Executor buildTaskExecutor(String prefix, int poolSize) throws UnknownHostException {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

    InetAddress localhost = InetAddress.getLocalHost();

    executor.initialize();
    executor.setCorePoolSize(poolSize);
    executor.setMaxPoolSize(poolSize);
    executor.setQueueCapacity(100);
    executor.setWaitForTasksToCompleteOnShutdown(true);
    executor.setAllowCoreThreadTimeOut(false);
    executor.setThreadNamePrefix(prefix + localhost.getHostName() + "-");

    return executor;
  }
}
