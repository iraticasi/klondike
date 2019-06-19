package klondike.distributed.dispatchers;

import klondike.controllers.implementation.SaveControllerImplementation;

public class SaveNamedDispatcher extends Dispatcher {

    public SaveNamedDispatcher(SaveControllerImplementation saveControllerImplementation) {
        super(saveControllerImplementation);
    }

    @Override
    public void dispatch() {
        ((SaveControllerImplementation) this.acceptorController).save();
    }

}
