package klondike.distributed.dispatchers;

import klondike.controllers.PlayController;

public class MoveFromWasteToStockDispatcher extends Dispatcher {

    public MoveFromWasteToStockDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((PlayController) this.acceptorController).moveFromWasteToStock());
    }

}
