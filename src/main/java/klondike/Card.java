package klondike;

import klondike.utils.IO;

public class Card {

    private Suit suit;

    private Number number;

    private boolean facedUp;

    public Card(Suit suit, Number number) {
        assert suit != null;
        assert number != null;
        this.suit = suit;
        this.number = number;
        this.facedUp = false;
    }

    public Card flip() {
        this.facedUp = !this.facedUp;
        return this;
    }

    public boolean isFacedUp() {
        return this.facedUp;
    }

    public boolean isNextTo(Card card) {
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

    public void write() {
        String number = this.facedUp ? this.number.toString().toLowerCase() : Message.FACE_DOWN;
        String suit = this.facedUp ? this.suit.toString().toLowerCase() : Message.FACE_DOWN;
        String output = Message.CARD_FORMAT.replace(Message.NUMBER_TAG, number).replace(Message.SUIT_TAG, suit);
        IO.write(output);
    }

    public void writeln() {
        this.write();
        IO.writeln();
    }
}