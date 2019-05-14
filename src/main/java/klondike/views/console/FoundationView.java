package klondike.views.console;

import klondike.models.Card;
import klondike.models.Suit;
import klondike.utils.IO;

public class FoundationView {

    private final Card card;
    private final Suit suit;

    FoundationView(Suit suit, Card card) {
        this.suit = suit;
        this.card = card;
    }


    public void writeln() {
        IO.writetab();
        IO.write(this.suit.toString().toLowerCase() + ": ");
        if (this.card == null) {
            IO.write(Message.EMPTY);
        } else {
            IO.write(Message.FOUNDATION_FORMAT.replace(Message.NUMBER_TAG, card.getNumber().toString().toLowerCase()));
        }
        IO.writeln();
    }
}
