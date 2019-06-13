package klondike.distributed.dispatchers;

import klondike.controllers.PlayController;
import klondike.models.Suit;

public class MoveFromPileToFoundationDispatcher extends Dispatcher {

    public MoveFromPileToFoundationDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        int pileIndex = this.tcpip.receiveInt();
        Suit suit = this.tcpip.receiveSuit();
        this.tcpip.send(((PlayController) this.acceptorController).moveFromPileToFoundation(pileIndex, suit));
    }
}
