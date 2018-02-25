package injector;

import service.Consumer;
import service.DIApp;
import service.FacebookService;

public class FacebookServiceInjector implements MessageServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new DIApp(new FacebookService());
    }
}
