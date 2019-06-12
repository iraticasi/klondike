package klondike.distributed.dispatchers;

import klondike.controllers.PlayController;
import klondike.models.Suit;

public class MoveFromWasteToFoundationDispatcher extends Dispatcher {

    public MoveFromWasteToFoundationDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        Suit suit = this.tcpip.receiveSuit();
        this.tcpip.send(((PlayController) this.acceptorController).moveFromWasteToFoundation(suit));
    }

}
