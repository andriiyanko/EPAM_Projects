package service;

public interface Consumer {

    void processMessage(String message, String recipient);
}
