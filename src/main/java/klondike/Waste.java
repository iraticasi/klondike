package klondike;

import klondike.utils.IO;

public class Waste extends CardStack {

    public void writeln() {
        IO.write(Message.WASTE_TITLE);
        if (this.empty()) {
            IO.writeln(Message.EMPTY);
        } else {
            this.peek().writeln();
        }
    }
}
