package io.nnc.bookinfoservice.service.notification;

public class SendEmailService implements MessageService {

  @Override
  public void send(String message) {
    if (message.isEmpty()) {
      throw new RuntimeException();
    }
    System.out.println("SendEmailService");
  }
}
