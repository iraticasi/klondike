package klondike.distributed.dispatchers;

import klondike.controllers.StartController;
import klondike.distributed.dispatchers.Dispatcher;

public class StartDispatcher extends Dispatcher {

    public StartDispatcher(StartController startController) {
        super(startController);
    }

    @Override
    public void dispatch() {
        ((StartController) this.acceptorController).start();
    }

}