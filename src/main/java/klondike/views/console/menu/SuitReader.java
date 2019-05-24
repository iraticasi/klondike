package klondike.views.console.menu;

import klondike.models.Suit;
import klondike.utils.IO;

public class SuitReader {

    public static Suit read() {
        char initial = IO.readChar(Message.READ_SUIT, Suit.initials());
        return Suit.find(initial);
    }
}
