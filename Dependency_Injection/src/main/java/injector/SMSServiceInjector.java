package injector;

import service.Consumer;
import service.DIApp;
import service.SMSService;

public class SMSServiceInjector implements MessageServiceInjector {
    @Override
    public Consumer getConsumer() {
        return new DIApp(new SMSService());
    }
}
