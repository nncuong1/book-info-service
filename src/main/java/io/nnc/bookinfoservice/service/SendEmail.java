package io.nnc.bookinfoservice.service;

public class SendEmail implements MessageService{
    @Override
    public void send() {
        System.out.println("Send email");
    }
}
