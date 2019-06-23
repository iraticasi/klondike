package klondike.models;

import klondike.utils.Registry;

import java.util.Stack;

public class SessionImplementation implements Session {

    private State state;

    private Game game;

    private Registry registry;

    private String name;

    public SessionImplementation() {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(this.game);
    }

    public Game getGame() {
        return this.game;
    }

    public void resetRegistry() {
        this.registry.reset();
    }

    public void setStateValue(StateValue value) {
        this.state.setStateValue(value);
    }

    public boolean hasName() {
        return this.name != null;
    }

    public void resume() {
        this.game.clear();
        this.state.reset();
        this.registry.reset();
    }

    public void next() {
        this.state.next();
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

    @Override
    public Card peekStock() {
        return this.game.peekStock();
    }

    @Override
    public Card peekWaste() {
        return this.game.peekWaste();
    }

    @Override
    public Card peekFoundation(Suit suit) {
        return this.game.peekFoundation(suit);
    }

    @Override
    public Stack<Card> getPileCards(int index) {
        return this.game.getPileCards(index);
    }

    @Override
    public int getNumberOfFaceUpCardsInPile(int index) {
        return this.game.getNumberOfFaceUpCardsInPile(index);
    }

    @Override
    public boolean isGameFinished() {
        return this.game.isFinished();
    }

    @Override
    public StateValue getValueState() {
        return this.state.getValueState();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
