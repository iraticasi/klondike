package klondike.models;

public enum Suit {

    HEARTS(Color.RED),
    DIAMONDS(Color.RED),
    CLOVERS(Color.BLACK),
    PIKES(Color.BLACK);

    public static final char[] initials = new char[]{'H', 'D', 'C', 'P'};

    private final Color color;

    Suit(Color color) {
        this.color = color;
    }

    public static Suit find(char initial) {
        for (int i = 0; i < Suit.initials.length; i++)
            if (initial == Suit.initials[i]) {
                return Suit.values()[i];
            }
        return null;
    }

    public Color getColor() {
        return this.color;
    }

}
