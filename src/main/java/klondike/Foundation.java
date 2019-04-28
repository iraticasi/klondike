package klondike;

import klondike.utils.IO;

import java.util.Stack;

public class Foundation {

    private Stack<Card> cards;

    private Suit suit;

    public Foundation(Suit suit) {
        super();
        this.cards = new Stack<>();
        this.suit = suit;
    }

    public boolean isComplete() {
        return this.cards.size() == Number.values().length;
    }

    public boolean fitsIn(Card card) {
        assert card != null;
        return card.getSuit() == this.suit &&
                (card.getNumber() == Number.AS ||
                        (!this.empty() && card.isNextNumberTo(this.peek())));
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

    public void writeln() {
        IO.writetab();
        IO.write(this.suit.toString().toLowerCase() + ": ");
        if (this.empty()) {
            IO.write("empty");
        } else {
            IO.write("until " + this.peek().getNumber().toString().toLowerCase());
        }
        IO.writeln();
    }
}
