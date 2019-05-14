package klondike.controllers;

import klondike.models.*;

import java.util.Stack;

public abstract class Controller {

    final Game game;

    Controller(Game game) {
        this.game = game;
    }

    public Card peekStock() {
        Stock stock = this.game.getStock();
        return peekIfNotEmpty(stock);
    }

    public Card peekWaste() {
        Waste waste = this.game.getWaste();
        return peekIfNotEmpty(waste);
    }

    public Card peekFoundation(Suit suit) {
        Foundation foundation = this.game.getFoundation(suit);
        return peekIfNotEmpty(foundation);
    }

    private Card peekIfNotEmpty(CardStack cardStack) {
        if (cardStack.empty()) {
            return null;
        } else {
            return cardStack.peek();
        }
    }

    public Stack<Card> getPileCards(int pileIndex) {
        return this.game.getPile(pileIndex).getCards();
    }
}
