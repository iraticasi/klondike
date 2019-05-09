package klondike.menu;

public enum Message {

    STOCK2WASTE_COMMAND("Move from stock to waste"),
    WASTE2STOCK_COMMAND("Move from waste to stock"),
    WASTE2FOUNDATION_COMMAND("Move from waste to foundation"),
    WASTE2PILE_COMMAND("Move from waste to pile"),
    FOUNDATION2PILE_COMMAND("Move from foundation to pile"),
    PILE2FOUNDATION_COMMAND("Move from pile to foundation"),
    PILE2PILE_COMMAND("Move from pile to pile");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
