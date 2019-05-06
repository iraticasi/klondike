package klondike;

import klondike.utils.IO;

public enum Suit {

    HEARTS(Color.RED),
    DIAMONDS(Color.RED),
    CLOVERS(Color.BLACK),
    PIKES(Color.BLACK);

    private final Color color;

    Suit(Color color) {
        this.color = color;
    }

    public static Suit read() {
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

    public Color getColor() {
        return this.color;
    }

}
