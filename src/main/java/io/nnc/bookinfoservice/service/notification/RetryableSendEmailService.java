package io.nnc.bookinfoservice.service.notification;

import io.nnc.bookinfoservice.util.ExceptionUtils;

public class RetryableSendEmailService extends SendEmailService {

  @Override
  public void send(String message) {
    ExceptionUtils.retryOnException(() -> super.send(message), 3, 5000);
  }
}
