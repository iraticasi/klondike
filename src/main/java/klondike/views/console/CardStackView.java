package klondike.views.console;

import klondike.models.Card;
import klondike.utils.IO;

public abstract class CardStackView {

    private final String title;

    CardStackView(String title){
        this.title = title;
    }

    protected void writeln(Card card) {
        IO.write(title);
        if (card == null)
            IO.writeln(Message.EMPTY);
        else
            new CardView(card).writeln();
    }

    public abstract void writeln();
}
