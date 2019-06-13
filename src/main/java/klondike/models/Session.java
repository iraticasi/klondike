package klondike.models;

import klondike.distributed.dispatchers.FrameType;
import klondike.distributed.dispatchers.TCPIP;
import klondike.utils.Registry;

import java.util.Stack;

public class Session {

    private State state;

    private Game game;

    private Registry registry;

    private TCPIP tcpip;

    public Session(TCPIP tcpip) {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(this.game);
        this.tcpip = tcpip;
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

    public Card peekStock() {
        if (this.tcpip == null) {
            return this.game.peekStock();
        }
        this.tcpip.send(FrameType.PEEKSTOCK.name());
        return this.tcpip.receiveCard();
    }

    public Card peekWaste() {
        if (this.tcpip == null) {
            return this.game.peekWaste();
        }
        this.tcpip.send(FrameType.PEEKWASTE.name());
        return this.tcpip.receiveCard();
    }

    public Card peekFoundation(Suit suit) {
        if (this.tcpip == null) {
            return this.game.peekFoundation(suit);
        }
        this.tcpip.send(FrameType.PEEKFOUNDATION.name());
        this.tcpip.send(suit);
        return this.tcpip.receiveCard();
    }

    public Stack<Card> getPileCards(int index) {
        if (this.tcpip == null) {
            return this.game.getPileCards(index);
        }
        this.tcpip.send(FrameType.GETPILECARDS.name());
        this.tcpip.send(index);
        int numberOfCards = this.tcpip.receiveInt();
        Stack<Card> cards = new Stack<>();
        for (int i = 0; i < numberOfCards; i++) {
            cards.add(this.tcpip.receiveCard());
        }
        return cards;
    }

    public int getNumberOfFaceUpCardsInPile(int index) {
        if (this.tcpip == null) {
            return this.game.getNumberOfFaceUpCardsInPile(index);
        }
        this.tcpip.send(FrameType.GETNUMBEROFFACEDUPCARDSINPILE.name());
        this.tcpip.send(index);
        return this.tcpip.receiveInt();
    }

    public boolean isGameFinished() {
        return this.game.isFinished();
    }

    public StateValue getValueState() {
        if (this.tcpip == null) {
            return this.state.getValueState();
        }
        this.tcpip.send(FrameType.STATE.name());
        return StateValue.values()[this.tcpip.receiveInt()];
    }
}
