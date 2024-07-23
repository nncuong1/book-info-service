package io.nnc.bookinfoservice.service;

public class SendSms implements MessageService {
    @Override
    public void send() {
        System.out.println("Send sms");
    }
}
