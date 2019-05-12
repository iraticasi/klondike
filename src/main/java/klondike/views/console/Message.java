package klondike.views.console;

public class Message {

    public static final String NUMBER_TAG = "#number";
    public static final String SUIT_TAG = "#suit";
    public static final String PILE_TAG = "#pile";

    public static final String GAME_TITLE = "*********************KLONDIKE*********************";
    public static final String STOCK_TITLE = "STOCK: ";
    public static final String WASTE_TITLE = "WASTE: ";
    public static final String FOUNDATIONS_TITLE = "FOUNDATIONS: ";
    public static final String PILE_TITLE = "PILE #" + PILE_TAG + ": ";

    public static final String EMPTY = "empty";
    public static final String NOT_EMPTY = "not empty";

    public static final String FACE_DOWN = "XXXX";
    public static final String CARD_FORMAT = NUMBER_TAG + " of " + SUIT_TAG;
    public static final String FOUNDATION_FORMAT = "until " + NUMBER_TAG;

    public static final String INVALID_MOVE = "Invalid move";
    public static final String RESUME = "Do you want to resume?";
    public static final String READ_NUMBER_OF_CARDS = "How many cards do you want to move?: ";
    public static final String READ_SUIT = "Choose a suit (H/D/C/P): ";
    public static final String READ_PILE_INDEX = "Choose the " + PILE_TAG + " pile number(1-7): ";
    public static final String DESTINATION = "destination";
    public static final String ORIGIN = "origin";
}
