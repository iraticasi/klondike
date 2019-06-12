package klondike.distributed.dispatchers;

import klondike.controllers.PlayController;
import klondike.models.Suit;

public class PeekFoundationDispatcher extends Dispatcher {

    public PeekFoundationDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        Suit suit = this.tcpip.receiveSuit();
        this.tcpip.send(this.acceptorController.peekFoundation(suit));
    }
}