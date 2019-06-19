package klondike.controllers.implementation;

import klondike.controllers.*;
import klondike.models.Error;
import klondike.models.Session;
import klondike.models.Suit;

public class PlayControllerImplementation extends PlayController {

    private MoveController moveController;

    private UndoController undoController;

    private RedoController redoController;

    private ExitController exitController;

    PlayControllerImplementation(Session session) {
        super(session);
        this.moveController = new MoveController(this.session);
        this.undoController = new UndoController(this.session);
        this.redoController = new RedoController(this.session);
        this.exitController = new ExitController(this.session);
    }

    @Override
    public Error moveFromFoundationToPile(Suit suit, int pileIndex) {
        return this.moveController.moveFromFoundationToPile(suit, pileIndex);
    }

    @Override
    public Error moveFromPileToFoundation(int pileIndex, Suit suit) {
        return this.moveController.moveFromPileToFoundation(pileIndex, suit);
    }

    @Override
    public Error moveFromPileToPile(int originIndex, int destinationIndex, int numberOfCards) {
        return this.moveController.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
    }

    @Override
    public Error moveFromStockToWaste() {
        return this.moveController.moveFromStockToWaste();
    }

    @Override
    public Error moveFromWasteToFoundation(Suit suit) {
        return this.moveController.moveFromWasteToFoundation(suit);
    }

    @Override
    public Error moveFromWasteToPile(int pileIndex) {
        return this.moveController.moveFromWasteToPile(pileIndex);
    }

    @Override
    public Error moveFromWasteToStock() {
        return this.moveController.moveFromWasteToStock();
    }

    @Override
    public void undo() {
        this.undoController.undo();
    }

    @Override
    public void redo() {
        this.redoController.redo();
    }

    @Override
    public boolean undoable() {
        return this.undoController.undoable();
    }

    @Override
    public boolean redoable() {
        return this.redoController.redoable();
    }

    @Override
    public void next() {
        this.exitController.next();
    }

}
