package service;

public class SMSService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("SMS was sent to " + recipient + " with Message = " + message);
    }
}
