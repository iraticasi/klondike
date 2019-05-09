package klondike;

import klondike.utils.IO;

public class Waste extends CardStack {

    private static final String TITLE = "WASTE: ";

    public void writeln() {
        IO.write(Waste.TITLE);
        if (this.empty()) {
            IO.writeln("empty");
        } else {
            this.peek().writeln();
        }
    }
}
