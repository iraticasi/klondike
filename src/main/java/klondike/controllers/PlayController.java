package klondike.controllers;

import klondike.models.Error;
import klondike.models.Session;
import klondike.models.Suit;

public class PlayController extends AcceptorController {

    private MoveController moveController;

    private UndoController undoController;

    private RedoController redoController;

    PlayController(Session session) {
        super(session);
        this.moveController = new MoveController(this.session);
        this.undoController = new UndoController(this.session);
        this.redoController = new RedoController(this.session);
    }

    public Error moveFromFoundationToPile(Suit suit, int pileIndex) {
        return this.moveController.moveFromFoundationToPile(suit, pileIndex);
    }

    public Error moveFromPileToFoundation(int pileIndex, Suit suit) {
        return this.moveController.moveFromPileToFoundation(pileIndex, suit);
    }

    public Error moveFromPileToPile(int originIndex, int destinationIndex, int numberOfCards) {
        return this.moveController.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
    }

    public Error moveFromStockToWaste() {
        return this.moveController.moveFromStockToWaste();
    }

    public Error moveFromWasteToFoundation(Suit suit) {
        return this.moveController.moveFromWasteToFoundation(suit);
    }

    public Error moveFromWasteToPile(int pileIndex) {
        return this.moveController.moveFromWasteToPile(pileIndex);
    }

    public Error moveFromWasteToStock() {
        return this.moveController.moveFromWasteToStock();
    }

    public void undo() {
        this.undoController.undo();
    }

    public void redo() {
        this.redoController.redo();
    }

    public boolean undoable() {
        return this.undoController.undoable();
    }

    public boolean redoable() {
        return this.redoController.redoable();
    }


    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
