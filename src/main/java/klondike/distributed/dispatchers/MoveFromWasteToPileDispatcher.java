package klondike.distributed.dispatchers;

import klondike.controllers.PlayController;

public class MoveFromWasteToPileDispatcher extends Dispatcher {

    public MoveFromWasteToPileDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        int pileIndex =this.tcpip.receiveInt();
        this.tcpip.send(((PlayController) this.acceptorController).moveFromWasteToPile(pileIndex));
    }

}
