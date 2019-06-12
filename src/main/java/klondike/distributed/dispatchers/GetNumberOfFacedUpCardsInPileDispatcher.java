package klondike.distributed.dispatchers;

import klondike.controllers.PlayController;

public class GetNumberOfFacedUpCardsInPileDispatcher extends Dispatcher {

    public GetNumberOfFacedUpCardsInPileDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        int index = this.tcpip.receiveInt();
        this.tcpip.send(this.acceptorController.getNumberOfFaceUpCardsInPile(index));
    }
}
