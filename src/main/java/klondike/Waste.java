package klondike;

import klondike.utils.IO;

public class Waste extends CardStack {

    public void writeln() {
        if (this.empty()) {
            IO.writeln("empty");
        } else {
            this.peek().writeln(true);
        }
    }
}
