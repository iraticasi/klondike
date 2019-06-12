package klondike.distributed.dispatchers;

import klondike.controllers.PlayController;
import klondike.models.Suit;

public class MoveFromPileToPileDispatcher extends Dispatcher {

    public MoveFromPileToPileDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        int originIndex = this.tcpip.receiveInt();
        int destinationIndex = this.tcpip.receiveInt();
        int numberOfCards = this.tcpip.receiveInt();
        this.tcpip.send(((PlayController) this.acceptorController).moveFromPileToPile(originIndex,destinationIndex,numberOfCards));
    }

}
