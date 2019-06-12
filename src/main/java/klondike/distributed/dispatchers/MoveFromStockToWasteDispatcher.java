package klondike.distributed.dispatchers;

import klondike.controllers.PlayController;


public class MoveFromStockToWasteDispatcher extends Dispatcher {

    public MoveFromStockToWasteDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((PlayController) this.acceptorController).moveFromStockToWaste());
    }
}