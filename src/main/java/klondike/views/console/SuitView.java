package klondike.views.console;

import klondike.models.Suit;
import klondike.utils.IO;

public class SuitView {

    public static Suit read() {
        char initial = IO.readChar(Message.READ_SUIT, Suit.initials());
        return Suit.find(initial);
    }
}
