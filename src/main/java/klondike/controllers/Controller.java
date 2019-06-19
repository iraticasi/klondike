package klondike.controllers;

import klondike.models.Card;
import klondike.models.Session;
import klondike.models.StateValue;
import klondike.models.Suit;

import java.util.Stack;

public abstract class Controller {

    protected Session session;

    Controller(Session session) {
        this.session = session;
    }

    public Card peekStock() {
        return this.session.peekStock();
    }

    public Card peekWaste() {
        return this.session.peekWaste();
    }

    public Card peekFoundation(Suit suit) {
        return this.session.peekFoundation(suit);
    }


    public Stack<Card> getPileCards(int index) {
        return this.session.getPileCards(index);
    }

    public int getNumberOfFaceUpCardsInPile(int index) {
        return this.session.getNumberOfFaceUpCardsInPile(index);
    }

    public StateValue getValueState() {
        return this.session.getValueState();
    }

    public String getName() {
        return this.session.getName();
    }

    public void setName(String name) {
        this.session.setName(name);
    }
}
