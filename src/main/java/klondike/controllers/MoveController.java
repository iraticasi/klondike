package klondike.controllers;

import klondike.models.Error;
import klondike.models.Session;
import klondike.models.SessionImplementation;
import klondike.models.Suit;

public class MoveController extends Controller {

    public MoveController(Session session) {
        super(session);
    }

    public Error moveFromFoundationToPile(Suit suit, int pileIndex) {
        return ((SessionImplementation) this.session).moveFromFoundationToPile(suit, pileIndex);
    }

    public Error moveFromPileToFoundation(int pileIndex, Suit suit) {
        Error error = ((SessionImplementation) this.session).moveFromPileToFoundation(pileIndex, suit);
        if (error == null && this.session.isGameFinished()) {
            ((SessionImplementation) this.session).next();
        }
        return error;
    }

    public Error moveFromPileToPile(int originIndex, int destinationIndex, int numberOfCards) {
        return ((SessionImplementation) this.session).moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
    }

    public Error moveFromStockToWaste() {
        return ((SessionImplementation) this.session).moveFromStockToWaste();
    }

    public Error moveFromWasteToFoundation(Suit suit) {
        Error error = ((SessionImplementation) this.session).moveFromWasteToFoundation(suit);
        if (error == null && this.session.isGameFinished()) {
            ((SessionImplementation) this.session).next();
        }
        return error;
    }

    public Error moveFromWasteToPile(int pileIndex) {
        return ((SessionImplementation) this.session).moveFromWasteToPile(pileIndex);
    }

    public Error moveFromWasteToStock() {
        return ((SessionImplementation) this.session).moveFromWasteToStock();
    }
}
