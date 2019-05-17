package klondike;

import klondike.utils.ClosedInterval;
import klondike.utils.IO;

import java.util.ArrayList;
import java.util.List;

public class Pile extends CardStack {

    private final int number;

    private int numberOfFaceUpCards;

    public Pile(int number, List<Card> cards) {
        this.number = number;
        this.numberOfFaceUpCards = 0;
        this.cards.addAll(cards);
        if (!this.cards.empty()) {
            this.flipFirstCard();
        }
    }

    public static int readIndex(String title) {
        return IO.readInt(Message.READ_PILE_INDEX.replace(Message.PILE_TAG, title), new ClosedInterval(1, 7)) - 1;
    }

    private void flipFirstCard() {
        assert !this.cards.empty() && this.numberOfFaceUpCards == 0 && this.cards.peek().isFacedUp();
        this.cards.peek().flip();
        this.numberOfFaceUpCards++;
    }

    public boolean fitsIn(Card card) {
        assert card != null;
        return (this.cards.empty() && card.getNumber() == Number.KING) ||
                (!this.cards.empty() && this.cards.peek().isNextTo(card) && this.cards.peek().getColor() != card.getColor());
    }

    public List<Card> getTop(int numberOfCards) {
        assert numberOfCards <= this.numberOfFaceUpCards;
        return new ArrayList<>(this.cards.subList(this.cards.size() - numberOfCards, this.cards.size()));
    }

    public void addToTop(List<Card> cards) {
        assert cards != null;
        this.cards.addAll(cards);
        this.numberOfFaceUpCards += cards.size();
    }

    public void removeTop(int numberOfCards) {
        assert numberOfCards <= this.numberOfFaceUpCards;
        for (int i = 0; i < numberOfCards; i++) {
            this.cards.pop();
            this.numberOfFaceUpCards--;
        }
        if (this.numberOfFaceUpCards == 0 && !this.cards.empty()) {
            this.flipFirstCard();
        }
    }

    public int numberOfFaceUpCards() {
        return this.numberOfFaceUpCards;
    }

    private int numberOfFaceDownCards(){
        return this.cards.size() - this.numberOfFaceUpCards;
    }

    public boolean empty() {
        return this.cards.empty();
    }

    public void writeln() {
        IO.writetab();
        IO.write(this.number + ": ");
        if (this.cards.empty()) {
            IO.write(Message.EMPTY);
        } else {
            if (this.numberOfFaceDownCards()>0) {
                this.cards.get(0).write();
                IO.write(" (x" + this.numberOfFaceDownCards() + "), ");
            }
            for (int i = 0; i<this.numberOfFaceUpCards; i++){
                Card card = this.cards.get(numberOfFaceDownCards() + i);
                card.write();
                if (i<this.numberOfFaceUpCards-1){
                    IO.write(", ");
                }
            }
        }
        IO.writeln();
    }
}
