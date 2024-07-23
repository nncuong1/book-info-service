package io.nnc.bookinfoservice.service;

public class NotificationApp {

    public static void main(String[] args) {
        SendEmail email = new SendEmail();

        // send email
        Notification notification = new Notification(email);
        notification.send();

        // send sms
        SendSms sms = new SendSms();
        notification.setMessageService(sms);
        notification.send();
    }
}
