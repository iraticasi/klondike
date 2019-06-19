package klondike.distributed.dispatchers;

import klondike.controllers.implementation.PlayControllerImplementation;

public class MoveFromWasteToStockDispatcher extends Dispatcher {

    public MoveFromWasteToStockDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((PlayControllerImplementation) this.acceptorController).moveFromWasteToStock());
    }

}
