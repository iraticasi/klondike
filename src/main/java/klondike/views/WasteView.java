package klondike.views;

import klondike.models.CardStack;
import klondike.utils.IO;

public class WasteView {

    private final CardStack waste;

    WasteView(CardStack waste) {
        this.waste = waste;
    }

    public void writeln() {
        IO.write(Message.WASTE_TITLE);
        if (this.waste.empty()) {
            IO.writeln(Message.EMPTY);
        } else {
            new CardView(this.waste.peek()).writeln();
        }
    }
}
