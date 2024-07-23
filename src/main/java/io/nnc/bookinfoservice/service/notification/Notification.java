package io.nnc.bookinfoservice.service.notification;

public class Notification {
  private MessageService messageService;

  public Notification(MessageService messageService) {
    this.messageService = messageService;
  }

  public void send(String message) {
    messageService.send(message);
  }

  public void setMessageService(MessageService messageService) {
    this.messageService = messageService;
  }
}
