package klondike;

import klondike.utils.IO;

public enum Suit {

    HEARTS(Color.RED, 'H'),
    DIAMONDS(Color.RED, 'D'),
    CLOVERS(Color.BLACK, 'C'),
    PIKES(Color.BLACK, 'P');

    private final Color color;
    private final char initial;

    Suit(Color color, char initial) {
        this.color = color;
        this.initial = initial;
    }

    public static Suit read() {
        char initial = IO.readChar(Message.READ_SUIT, Suit.initials());
        return Suit.find(initial);
    }

    private static char[] initials() {
        char[] initials = new char[Suit.values().length];
        for (Suit suit : Suit.values()) {
            initials[suit.ordinal()] = suit.initial;
        }
        return initials;
    }

    private static Suit find(char initial) {
        for (Suit suit : Suit.values())
            if (initial == suit.initial) {
                return suit;
            }
        return null;
    }

    public Color getColor() {
        return this.color;
    }
}
