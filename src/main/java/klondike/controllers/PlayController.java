package klondike.controllers;

import klondike.distributed.dispatchers.FrameType;
import klondike.distributed.dispatchers.TCPIP;
import klondike.models.Error;
import klondike.models.Session;
import klondike.models.Suit;

public class PlayController extends AcceptorController {

    private MoveController moveController;

    private UndoController undoController;

    private RedoController redoController;

    protected PlayController(Session session, TCPIP tcpip) {
        super(session, tcpip);
        if (tcpip == null) {
            this.moveController = new MoveController(this.session);
            this.undoController = new UndoController(this.session);
            this.redoController = new RedoController(this.session);
        }
    }

    public Error moveFromFoundationToPile(Suit suit, int pileIndex) {
        if (this.tcpip == null) {
            return this.moveController.moveFromFoundationToPile(suit, pileIndex);
        }
        this.tcpip.send(FrameType.MOVEFROMFOUNDATIONTOPILE.name());
        this.tcpip.send(suit);
        this.tcpip.send(pileIndex);
        return this.tcpip.receiveError();
    }

    public Error moveFromPileToFoundation(int pileIndex, Suit suit) {
        if (this.tcpip == null) {
            return this.moveController.moveFromPileToFoundation(pileIndex, suit);
        }
        this.tcpip.send(FrameType.MOVEFROMPILETOFOUNDATION.name());
        this.tcpip.send(pileIndex);
        this.tcpip.send(suit);
        return this.tcpip.receiveError();
    }

    public Error moveFromPileToPile(int originIndex, int destinationIndex, int numberOfCards) {
        if (this.tcpip == null) {
            return this.moveController.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
        }
        this.tcpip.send(FrameType.MOVEFROMPILETOPILE.name());
        this.tcpip.send(originIndex);
        this.tcpip.send(destinationIndex);
        this.tcpip.send(numberOfCards);
        return this.tcpip.receiveError();
    }

    public Error moveFromStockToWaste() {
        if (this.tcpip == null) {
            return this.moveController.moveFromStockToWaste();
        }
        this.tcpip.send(FrameType.MOVEFROMSTOCKTOWASTE.name());
        return this.tcpip.receiveError();
    }

    public Error moveFromWasteToFoundation(Suit suit) {
        if (this.tcpip == null) {
            return this.moveController.moveFromWasteToFoundation(suit);
        }
        this.tcpip.send(FrameType.MOVEFROMWASTETOFOUNDATION.name());
        this.tcpip.send(suit);
        return this.tcpip.receiveError();
    }

    public Error moveFromWasteToPile(int pileIndex) {
        if (this.tcpip == null) {
            return this.moveController.moveFromWasteToPile(pileIndex);
        }
        this.tcpip.send(FrameType.MOVEFROMWASTETOPILE.name());
        this.tcpip.send(pileIndex);
        return this.tcpip.receiveError();

    }

    public Error moveFromWasteToStock() {
        if (this.tcpip == null) {
            return this.moveController.moveFromWasteToStock();
        }
        this.tcpip.send(FrameType.MOVEFROMWASTETOSTOCK.name());
        return this.tcpip.receiveError();
    }

    public void undo() {
        if (this.tcpip == null) {
            this.undoController.undo();
        } else {
            this.tcpip.send(FrameType.UNDO.name());
        }
    }

    public void redo() {
        if (this.tcpip == null) {
            this.redoController.redo();
        } else {
            this.tcpip.send(FrameType.REDO.name());
        }
    }

    public boolean undoable() {
        if (this.tcpip == null) {
            return this.undoController.undoable();
        }
        this.tcpip.send(FrameType.UNDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    public boolean redoable() {
        if (this.tcpip == null) {
            return this.redoController.redoable();
        }
        this.tcpip.send(FrameType.REDOABLE.name());
        return this.tcpip.receiveBoolean();
    }


    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
