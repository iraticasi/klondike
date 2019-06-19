package klondike.distributed.dispatchers;

import klondike.controllers.implementation.PlayControllerImplementation;
import klondike.models.Suit;

public class MoveFromPileToFoundationDispatcher extends Dispatcher {

    public MoveFromPileToFoundationDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        int pileIndex = this.tcpip.receiveInt();
        Suit suit = this.tcpip.receiveSuit();
        this.tcpip.send(((PlayControllerImplementation) this.acceptorController).moveFromPileToFoundation(pileIndex, suit));
    }
}
