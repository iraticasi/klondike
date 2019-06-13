package klondike.distributed.dispatchers;

import klondike.controllers.PlayController;
import klondike.controllers.implementation.PlayControllerImplementation;

public class UndoDispatcher extends Dispatcher {

    public UndoDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        ((PlayControllerImplementation) this.acceptorController).undo();
    }

}

