package io.nnc.bookinfoservice.service.notification;

public class SendSmsService implements MessageService {


  @Override
  public void send(String message) {
    System.out.println("SendSms");
  }
}
