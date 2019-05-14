package klondike.views.console;

import klondike.models.Card;
import klondike.utils.IO;

public class WasteView {

    private final Card card;

    WasteView(Card card) {
        this.card = card;
    }

    public void writeln() {
        IO.write(Message.WASTE_TITLE);
        if (this.card == null) {
            IO.writeln(Message.EMPTY);
        } else {
            new CardView(this.card).writeln();
        }
    }
}
