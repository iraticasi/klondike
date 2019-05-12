package klondike.views.console;

import klondike.models.Waste;
import klondike.utils.IO;

public class WasteView {

    private final Waste waste;

    WasteView(Waste waste) {
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
