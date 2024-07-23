package io.nnc.bookinfoservice.service.notification;

public class NotificationApp {

  public static void main(String[] args) {
    RetryableSendEmailService retryableSendEmailService = new RetryableSendEmailService();

    // send email
    Notification notification = new Notification(retryableSendEmailService);
    notification.send("");
  }
}
