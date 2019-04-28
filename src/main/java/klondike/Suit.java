package klondike;

public enum Suit {

    HEARTS,
    DIAMONDS,
    CLOVERS,
    PIKES;

    public Color getColor() {
        switch (this) {
            case HEARTS:
            case DIAMONDS:
                return Color.RED;
            case CLOVERS:
            case PIKES:
                return Color.BLACK;
        }
        return null;
    }
}
