package injector;

import service.Consumer;
import service.DIApp;
import service.EmailService;

public class EmailServiceInjector implements MessageServiceInjector {
    @Override
    public Consumer getConsumer() {
        return new DIApp(new EmailService());
    }
}
