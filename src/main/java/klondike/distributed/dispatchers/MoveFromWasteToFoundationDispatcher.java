package klondike.distributed.dispatchers;

import klondike.controllers.PlayController;
import klondike.controllers.implementation.PlayControllerImplementation;
import klondike.models.Suit;

public class MoveFromWasteToFoundationDispatcher extends Dispatcher {

    public MoveFromWasteToFoundationDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        Suit suit = this.tcpip.receiveSuit();
        this.tcpip.send(((PlayControllerImplementation) this.acceptorController).moveFromWasteToFoundation(suit));
    }

}
