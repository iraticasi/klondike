package klondike.distributed.dispatchers;

import klondike.controllers.PlayController;

public class PeekStockDispatcher extends Dispatcher {

    public PeekStockDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(this.acceptorController.peekStock());
    }

}
