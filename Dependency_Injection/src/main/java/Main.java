import injector.EmailServiceInjector;
import injector.FacebookServiceInjector;
import injector.MessageServiceInjector;
import injector.SMSServiceInjector;
import service.Consumer;

public class Main {

    public static void main(String[] args) {
        String message = "Hi Mr.Smith";
        String email = "smith@gmail.com";
        String phone = "380639276458";
        String user = "Johny_Smith_95";
        MessageServiceInjector injector;
        Consumer consumer;

        injector = new EmailServiceInjector();
        consumer = injector.getConsumer();
        consumer.processMessage(message, email);

        injector = new SMSServiceInjector();
        consumer = injector.getConsumer();
        consumer.processMessage(message, phone);

        injector = new FacebookServiceInjector();
        consumer = injector.getConsumer();
        consumer.processMessage(message, user);
    }
}
