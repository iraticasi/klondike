package klondike.controllers;

import klondike.models.Card;
import klondike.models.Game;
import klondike.models.State;
import klondike.models.Suit;

import java.util.Stack;

public abstract class Controller {

    protected Game game;

    protected State state;

    Controller(Game game, State state) {
        this.game = game;
        this.state = state;
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
}
