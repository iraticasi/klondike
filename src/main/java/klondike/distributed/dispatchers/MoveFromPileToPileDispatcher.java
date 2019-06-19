package klondike.distributed.dispatchers;

import klondike.controllers.implementation.PlayControllerImplementation;

public class MoveFromPileToPileDispatcher extends Dispatcher {

    public MoveFromPileToPileDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        int originIndex = this.tcpip.receiveInt();
        int destinationIndex = this.tcpip.receiveInt();
        int numberOfCards = this.tcpip.receiveInt();
        this.tcpip.send(((PlayControllerImplementation) this.acceptorController).moveFromPileToPile(originIndex, destinationIndex, numberOfCards));
    }

}
