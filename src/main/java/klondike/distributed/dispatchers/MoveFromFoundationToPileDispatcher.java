package klondike.distributed.dispatchers;

import klondike.controllers.implementation.PlayControllerImplementation;
import klondike.models.Suit;

public class MoveFromFoundationToPileDispatcher extends Dispatcher {

    public MoveFromFoundationToPileDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        Suit suit = this.tcpip.receiveSuit();
        int pileIndex = this.tcpip.receiveInt();
        this.tcpip.send(((PlayControllerImplementation) this.acceptorController).moveFromFoundationToPile(suit, pileIndex));
    }
}
