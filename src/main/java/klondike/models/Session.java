package klondike.models;

import java.util.Stack;

public class Session {

    private State state;

    private Game game;

    private Registry registry;

    public Session() {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(this.game);
    }

    public void resume() {
        this.game.clear();
        this.state.reset();
        this.registry.reset();
    }

    public void next() {
        this.state.next();
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public boolean undoable() {
        return this.registry.undoable();
    }

    public boolean redoable() {
        return this.registry.redoable();
    }

    public void undo() {
        this.registry.undo(this.game);
    }

    public void redo() {
        this.registry.redo(this.game);
    }

    public Error moveFromFoundationToPile(Suit suit, int pileIndex) {
        Error error = this.game.moveFromFoundationToPile(suit, pileIndex);
        if (error == null) {
            this.registry.registry();
        }
        return error;
    }

    public Error moveFromPileToFoundation(int pileIndex, Suit suit) {
        Error error = this.game.moveFromPileToFoundation(pileIndex, suit);
        if (error == null) {
            this.registry.registry();
        }
        return error;
    }

    public Error moveFromPileToPile(int originIndex, int destinationIndex, int numberOfCards) {
        Error error = this.game.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
        if (error == null) {
            this.registry.registry();
        }
        return error;
    }

    public Error moveFromStockToWaste() {
        Error error = this.game.moveFromStockToWaste();
        if (error == null) {
            this.registry.registry();
        }
        return error;
    }

    public Error moveFromWasteToFoundation(Suit suit) {
        Error error = this.game.moveFromWasteToFoundation(suit);
        if (error == null) {
            this.registry.registry();
        }
        return error;
    }

    public Error moveFromWasteToPile(int pileIndex) {
        Error error = this.game.moveFromWasteToPile(pileIndex);
        if (error == null) {
            this.registry.registry();
        }
        return error;
    }

    public Error moveFromWasteToStock() {
        Error error = this.game.moveFromWasteToStock();
        if (error == null) {
            this.registry.registry();
        }
        return error;
    }

    public Card peekStock() {
        return this.game.peekStock();
    }

    public Card peekWaste() {
        return this.game.peekWaste();
    }

    public Card peekFoundation(Suit suit) {
        return this.game.peekFoundation(suit);
    }

    public Stack<Card> getPileCards(int index) {
        return this.game.getPileCards(index);
    }

    public int getNumberOfFaceUpCardsInPile(int index) {
        return this.game.getNumberOfFaceUpCardsInPile(index);
    }

    public boolean isGameFinished() {
        return this.game.isFinished();
    }
}
