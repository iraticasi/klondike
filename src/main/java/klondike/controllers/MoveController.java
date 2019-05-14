package klondike.controllers;

import klondike.models.Error;
import klondike.models.Game;
import klondike.models.Suit;

public class MoveController extends Controller {

    public MoveController(Game game) {
        super(game);
    }

    public Error moveFromFoundationToPile(Suit suit, int pileIndex) {
        return this.game.moveFromFoundationToPile(suit, pileIndex);
    }

    public Error moveFromPileToFoundation(int pileIndex, Suit suit) {
        return this.game.moveFromPileToFoundation(pileIndex, suit);
    }

    public Error moveFromPileToPile(int originIndex, int destinationIndex, int numberOfCards) {
        return this.game.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
    }

    public Error moveFromStockToWaste() {
        return this.game.moveFromStockToWaste();
    }

    public Error moveFromWasteToFoundation(Suit suit) {
        return this.game.moveFromWasteToFoundation(suit);
    }

    public Error moveFromWasteToPile(int pileIndex) {
        return this.game.moveFromWasteToPile(pileIndex);
    }

    public Error moveFromWasteToStock() {
        return this.game.moveFromWasteToStock();
    }

    public boolean isGameFinished() {
        return this.game.isFinished();
    }
}
