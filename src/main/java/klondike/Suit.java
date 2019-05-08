package klondike;

import klondike.utils.IO;

public enum Suit {

    HEARTS(Color.RED),
    DIAMONDS(Color.RED),
    CLOVERS(Color.BLACK),
    PIKES(Color.BLACK);

    private static final char[] initials = new char[]{'H', 'D', 'C', 'P'};

    private final Color color;

    Suit(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public static Suit read() {
        char initial = IO.readChar("Choose a suit (H/D/C/P): ", Suit.initials);
        return Suit.find(initial);
    }

    private static Suit find(char initial) {
        for (int i = 0; i < Suit.initials.length; i++)
            if (initial==Suit.initials[i]) {
                return Suit.values()[i];
            }
        return null;
    }

}
