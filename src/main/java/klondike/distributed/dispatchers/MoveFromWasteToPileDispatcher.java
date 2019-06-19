package klondike.distributed.dispatchers;

import klondike.controllers.implementation.PlayControllerImplementation;

public class MoveFromWasteToPileDispatcher extends Dispatcher {

    public MoveFromWasteToPileDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        int pileIndex = this.tcpip.receiveInt();
        this.tcpip.send(((PlayControllerImplementation) this.acceptorController).moveFromWasteToPile(pileIndex));
    }

}
