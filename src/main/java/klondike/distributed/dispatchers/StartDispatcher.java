package klondike.distributed.dispatchers;

import klondike.controllers.implementation.StartControllerImplementation;

public class StartDispatcher extends Dispatcher {

    public StartDispatcher(StartControllerImplementation startControllerImplementation) {
        super(startControllerImplementation);
    }

    @Override
    public void dispatch() {
        ((StartControllerImplementation) this.acceptorController).start();
    }

}