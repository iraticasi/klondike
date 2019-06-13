package klondike.controllers;

import klondike.models.Error;
import klondike.models.Session;
import klondike.models.Suit;

public abstract class PlayController extends AcceptorController {

    protected PlayController(Session session) {
        super(session);
    }

    public abstract Error moveFromFoundationToPile(Suit suit, int pileIndex);

    public abstract Error moveFromPileToFoundation(int pileIndex, Suit suit);

    public abstract Error moveFromPileToPile(int originIndex, int destinationIndex, int numberOfCards);

    public abstract Error moveFromStockToWaste();

    public abstract Error moveFromWasteToFoundation(Suit suit);

    public abstract Error moveFromWasteToPile(int pileIndex);

    public abstract Error moveFromWasteToStock();

    public abstract void undo();

    public abstract void redo();

    public abstract boolean undoable();

    public abstract boolean redoable();

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
