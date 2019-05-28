package klondike.controllers;

import klondike.models.Error;
import klondike.models.Session;
import klondike.models.Suit;

public class MoveController extends Controller {

    public MoveController(Session session) {
        super(session);
    }

    public Error moveFromFoundationToPile(Suit suit, int pileIndex) {
        return this.session.moveFromFoundationToPile(suit, pileIndex);
    }

    public Error moveFromPileToFoundation(int pileIndex, Suit suit) {
        Error error = this.session.moveFromPileToFoundation(pileIndex, suit);
        if (error == null && this.session.isGameFinished()) {
            this.session.next();
        }
        return error;
    }

    public Error moveFromPileToPile(int originIndex, int destinationIndex, int numberOfCards) {
        return this.session.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
    }

    public Error moveFromStockToWaste() {
        return this.session.moveFromStockToWaste();
    }

    public Error moveFromWasteToFoundation(Suit suit) {
        Error error = this.session.moveFromWasteToFoundation(suit);
        if (error == null && this.session.isGameFinished()) {
            this.session.next();
        }
        return error;
    }

    public Error moveFromWasteToPile(int pileIndex) {
        return this.session.moveFromWasteToPile(pileIndex);
    }

    public Error moveFromWasteToStock() {
        return this.session.moveFromWasteToStock();
    }

}
