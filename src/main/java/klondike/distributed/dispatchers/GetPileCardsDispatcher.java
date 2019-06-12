package klondike.distributed.dispatchers;

import klondike.controllers.PlayController;
import klondike.models.Card;

import java.util.Stack;

public class GetPileCardsDispatcher extends Dispatcher {

    public GetPileCardsDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        int index = this.tcpip.receiveInt();
        Stack<Card> cards = this.acceptorController.getPileCards(index);
        this.tcpip.send(cards.size());
        for (int i=0; i<cards.size(); i++){
            this.tcpip.send(cards.get(i));
        }
    }
}
