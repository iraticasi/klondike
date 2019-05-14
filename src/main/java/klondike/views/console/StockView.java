package klondike.views.console;

import klondike.models.Card;
import klondike.utils.IO;

public class StockView {

    private final Card card;

    StockView(Card card) {
        this.card = card;
    }

    public void writeln() {
        IO.write(Message.STOCK_TITLE);
        if (this.card == null)
            IO.writeln(Message.EMPTY);
        else
            new CardView(this.card).writeln();
    }
}
