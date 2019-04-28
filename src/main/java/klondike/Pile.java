package klondike;

import klondike.utils.IO;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pile {

    private Stack<Card> faceDownCards;

    private Stack<Card> faceUpCards;

    public Pile(List<Card> cards) {
        this.faceDownCards = new Stack<>();
        this.faceUpCards = new Stack<>();
        this.faceDownCards.addAll(cards);
        if (!this.faceDownCards.empty()){
            flipFirstCard();
        }
    }

    public boolean fitsIn(Card card) {
        assert card != null;
        return (this.faceUpCards.empty() && card.getNumber() == Number.KING) ||
                (!this.faceUpCards.empty() && this.faceUpCards.peek().isNextTo(card) && this.faceUpCards.peek().getColor() != card.getColor());
    }

    private void flipFirstCard() {
        assert this.faceUpCards.empty() && !this.faceDownCards.empty();
        this.faceUpCards.push(this.faceDownCards.pop());
    }

    public int numberOfFaceUpCards() {
        return this.faceUpCards.size();
    }

    public List<Card> getTop(int numberOfCards) {
        assert numberOfCards <= this.faceUpCards.size();
        return new ArrayList<>(this.faceUpCards.subList(this.faceUpCards.size() - numberOfCards, this.faceUpCards.size()));
    }

    public void addToTop(List<Card> cards) {
        assert cards != null;
        this.faceUpCards.addAll(cards);
    }

    public void removeTop(int numberOfCards) {
        assert numberOfCards <= this.faceUpCards.size();
        for (int i = 0; i < numberOfCards; i++) {
            this.faceUpCards.pop();
            if (this.faceUpCards.empty() && !this.faceDownCards.empty()) {
                flipFirstCard();
            }
        }
    }

    public boolean empty() {
        return this.faceUpCards.empty();
    }

    public void writeln() {
        if (this.faceUpCards.empty()) {
            IO.writeln("empty");
        } else {
            IO.writeln();
            if (!this.faceDownCards.empty()) {
                IO.writetab();
                IO.writeln(this.faceDownCards.size() + " face down cards");
            }
            for (Card card : this.faceUpCards) {
                IO.writetab();
                card.writeln();
            }
        }
    }
}
