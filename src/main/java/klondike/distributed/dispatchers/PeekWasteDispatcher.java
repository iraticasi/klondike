package klondike.distributed.dispatchers;

import klondike.controllers.PlayController;

public class PeekWasteDispatcher extends Dispatcher {

    public PeekWasteDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(this.acceptorController.peekWaste());
    }
}
