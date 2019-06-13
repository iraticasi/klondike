package klondike.distributed;

import klondike.controllers.PlayController;
import klondike.distributed.dispatchers.FrameType;
import klondike.distributed.dispatchers.TCPIP;
import klondike.models.Error;
import klondike.models.Session;
import klondike.models.Suit;

public class PlayControllerProxy extends PlayController {

    private final TCPIP tcpip;

    public PlayControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public Error moveFromFoundationToPile(Suit suit, int pileIndex) {
        this.tcpip.send(FrameType.MOVEFROMFOUNDATIONTOPILE.name());
        this.tcpip.send(suit);
        this.tcpip.send(pileIndex);
        return this.tcpip.receiveError();
    }

    @Override
    public Error moveFromPileToFoundation(int pileIndex, Suit suit) {
        this.tcpip.send(FrameType.MOVEFROMPILETOFOUNDATION.name());
        this.tcpip.send(pileIndex);
        this.tcpip.send(suit);
        return this.tcpip.receiveError();
    }

    @Override
    public Error moveFromPileToPile(int originIndex, int destinationIndex, int numberOfCards) {
        this.tcpip.send(FrameType.MOVEFROMPILETOPILE.name());
        this.tcpip.send(originIndex);
        this.tcpip.send(destinationIndex);
        this.tcpip.send(numberOfCards);
        return this.tcpip.receiveError();
    }

    @Override
    public Error moveFromStockToWaste() {
        this.tcpip.send(FrameType.MOVEFROMSTOCKTOWASTE.name());
        return this.tcpip.receiveError();
    }

    @Override
    public Error moveFromWasteToFoundation(Suit suit) {
        this.tcpip.send(FrameType.MOVEFROMWASTETOFOUNDATION.name());
        this.tcpip.send(suit);
        return this.tcpip.receiveError();
    }

    @Override
    public Error moveFromWasteToPile(int pileIndex) {
        this.tcpip.send(FrameType.MOVEFROMWASTETOPILE.name());
        this.tcpip.send(pileIndex);
        return this.tcpip.receiveError();
    }

    @Override
    public Error moveFromWasteToStock() {
        this.tcpip.send(FrameType.MOVEFROMWASTETOSTOCK.name());
        return this.tcpip.receiveError();
    }

    @Override
    public void undo() {
        this.tcpip.send(FrameType.UNDO.name());
    }

    @Override
    public void redo() {
        this.tcpip.send(FrameType.REDO.name());
    }

    @Override
    public boolean undoable() {
        this.tcpip.send(FrameType.UNDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean redoable() {
        this.tcpip.send(FrameType.REDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

}
