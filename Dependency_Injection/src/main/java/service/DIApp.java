package service;

public class DIApp implements Consumer {
    private MessageService messageService;

    public DIApp(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void processMessage(String message, String recipient) {
        messageService.sendMessage(message,recipient);
    }
}
