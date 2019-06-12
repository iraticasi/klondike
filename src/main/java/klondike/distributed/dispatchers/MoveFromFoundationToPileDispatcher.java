package klondike.distributed.dispatchers;

import klondike.controllers.PlayController;
import klondike.distributed.dispatchers.Dispatcher;
import klondike.models.Suit;

public class MoveFromFoundationToPileDispatcher extends Dispatcher {

    public MoveFromFoundationToPileDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        Suit suit= this.tcpip.receiveSuit();
        int pileIndex = this.tcpip.receiveInt();
        this.tcpip.send(((PlayController) this.acceptorController).moveFromFoundationToPile(suit, pileIndex));
    }
}
