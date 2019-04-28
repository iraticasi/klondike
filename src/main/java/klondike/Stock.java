package klondike;

import klondike.utils.IO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Stock {

    private Stack<Card> cards;


    public Stock() {
        super();
        this.cards = new Stack<>();
        for (Suit suit : Suit.values()) {
            for (Number number : Number.values()) {
                this.cards.add(new Card(suit, number));
            }
        }
        Collections.shuffle(this.cards);
    }

    public List<Card> takeTop(int quantity) {
        assert 0 < quantity && quantity <= this.cards.size();
        List<Card> cardsToReturn = new ArrayList<>(this.cards.subList(0, quantity));
        this.cards.removeAll(cardsToReturn);
        return cardsToReturn;
    }


    public boolean empty() {
        return this.cards.empty();
    }

    public Card pop() {
        return this.cards.pop();
    }

    public void push(Card card) {
        this.cards.push(card);
    }

    public void writeln() {
        if (this.empty())
            IO.writeln("empty");
        else
            IO.writeln("not empty");
    }

}
