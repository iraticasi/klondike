package klondike;

import klondike.utils.IO;

public class Card {

    private Suit suit;

    private Number number;

    public Card(Suit suit, Number number) {
        assert suit != null;
        assert number != null;
        this.suit = suit;
        this.number = number;
    }

    public boolean isNextNumberTo(Card card) {
        return (this.getNumber().getValue() - 1) == card.getNumber().getValue();
    }

    public Number getNumber() {
        return this.number;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Color getColor() {
        return this.suit.getColor();
    }

    public void writeln() {
        IO.writeln(this.number.toString().toLowerCase() + " of " + this.suit.toString().toLowerCase());
    }
}
