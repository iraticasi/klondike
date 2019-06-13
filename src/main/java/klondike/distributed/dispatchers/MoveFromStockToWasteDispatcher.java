package klondike.distributed.dispatchers;

import klondike.controllers.PlayController;
import klondike.controllers.implementation.PlayControllerImplementation;


public class MoveFromStockToWasteDispatcher extends Dispatcher {

    public MoveFromStockToWasteDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((PlayControllerImplementation) this.acceptorController).moveFromStockToWaste());
    }
}