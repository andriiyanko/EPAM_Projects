package service;

public class FacebookService implements MessageService {

    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("Message in facebook was sent to user " + recipient + " with Message = " + message);
    }
}
