package klondike;

import klondike.utils.IO;

public class Foundation extends CardStack {

    private Suit suit;

    public Foundation(Suit suit) {
        super();
        this.suit = suit;
    }

    public boolean isComplete() {
        return this.cards.size() == Number.values().length;
    }

    public boolean fitsIn(Card card) {
        assert card != null;
        return card.getSuit() == this.suit &&
                (card.getNumber() == Number.AS ||
                        (!this.empty() && card.isNextTo(this.peek())));
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
