package klondike.distributed.dispatchers;

import klondike.controllers.implementation.SaveControllerImplementation;

public class SaveDispatcher extends Dispatcher {

    public SaveDispatcher(SaveControllerImplementation saveControllerImplementation) {
        super(saveControllerImplementation);
    }

    @Override
    public void dispatch() {
        String name = this.tcpip.receiveLine();
        ((SaveControllerImplementation) this.acceptorController).save(name);
    }

}
