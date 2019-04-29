package klondike;

import klondike.utils.IO;

import java.util.Stack;

public class Waste {

    private Stack<Card> cards;

    public Waste() {
        super();
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

    public void writeln() {
        if (this.empty()) {
            IO.writeln("empty");
        } else {
            this.peek().writeln();
        }
    }
}
