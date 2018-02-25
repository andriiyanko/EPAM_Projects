package service;

public class EmailService implements MessageService {

    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("Email was sent to "+ recipient + " with Message = " + message);
    }
}
