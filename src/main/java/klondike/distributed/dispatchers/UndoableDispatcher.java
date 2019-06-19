package klondike.distributed.dispatchers;

import klondike.controllers.implementation.PlayControllerImplementation;

public class UndoableDispatcher extends Dispatcher {

    public UndoableDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((PlayControllerImplementation) this.acceptorController).undoable());
    }

}

