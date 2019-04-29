package klondike.menu;

import klondike.Suit;
import klondike.utils.ClosedInterval;
import klondike.utils.IO;

public class MenuIO {

    public static Suit readSuit() {
        char suitInitial = IO.readChar("Choose a suit (H/D/C/P): ", new char[]{'H', 'D', 'C', 'P'});
        switch (suitInitial) {
            case 'H':
                return Suit.HEARTS;
            case 'D':
                return Suit.DIAMONDS;
            case 'C':
                return Suit.CLOVERS;
            case 'P':
                return Suit.PIKES;
        }
        return null;
    }

    public static int readPileIndex(boolean isOrigin) {
        String pileTitle = isOrigin ? "origin" : "destination";
        return IO.readInt("Choose the " + pileTitle + " pile number(1-7): ", new ClosedInterval(1, 7)) - 1;
    }

    public static int readNumberOfCards() {
        return IO.readInt("How many cards do you want to move?: ", new ClosedInterval(1, 13));
    }
}
