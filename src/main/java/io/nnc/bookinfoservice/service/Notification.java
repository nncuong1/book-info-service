package io.nnc.bookinfoservice.service;

public class Notification {
    private MessageService messageService;

    public Notification(MessageService messageService) {
        this.messageService = messageService;
    }

    public void send() {
        messageService.send();
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
}
