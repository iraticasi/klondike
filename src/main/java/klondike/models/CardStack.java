package klondike.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class CardStack {

    protected Stack<Card> cards;

    public CardStack() {
        this.cards = new Stack<>();
    }

    public boolean empty() {
        return this.cards.empty();
    }

    public Card peek() {
        return this.cards.peek();
    }

    public Card pop() {
        return this.cards.pop();
    }

    public void push(Card card) {
        this.cards.push(card);
    }

    protected void copyCardsFrom(CardStack cardStack) {
        List<Card> copiedCards = new ArrayList<>();
        for (Card card : cardStack.cards) {
            copiedCards.add(card.copy());
        }
        this.cards.addAll(copiedCards);
    }
}
