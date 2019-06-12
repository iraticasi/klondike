package klondike.controllers;

import klondike.models.Error;
import klondike.models.Game;
import klondike.models.State;
import klondike.models.Suit;

public class MoveController extends Controller {

    public MoveController(Game game, State state) {
        super(game, state);
    }

    public Error moveFromFoundationToPile(Suit suit, int pileIndex) {
        return this.game.moveFromFoundationToPile(suit, pileIndex);
    }

    public Error moveFromPileToFoundation(int pileIndex, Suit suit) {
        Error error = this.game.moveFromPileToFoundation(pileIndex, suit);
        if (error == null && this.game.isFinished()) {
            this.state.next();
        }
        return error;
    }

    public Error moveFromPileToPile(int originIndex, int destinationIndex, int numberOfCards) {
        return this.game.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
    }

    public Error moveFromStockToWaste() {
        return this.game.moveFromStockToWaste();
    }

    public Error moveFromWasteToFoundation(Suit suit) {
        Error error = this.game.moveFromWasteToFoundation(suit);
        if (error == null && this.game.isFinished()) {
            this.state.next();
        }
        return error;
    }

    public Error moveFromWasteToPile(int pileIndex) {
        return this.game.moveFromWasteToPile(pileIndex);
    }

    public Error moveFromWasteToStock() {
        return this.game.moveFromWasteToStock();
    }
}
