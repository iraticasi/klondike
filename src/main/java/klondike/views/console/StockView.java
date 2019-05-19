package klondike.views.console;

import klondike.controllers.Logic;

public class StockView extends CardStackView {

    private final Logic logic;

    public StockView(Logic logic) {
        super(Message.STOCK_TITLE);
        this.logic = logic;
    }

    public void writeln() {
        super.writeln(this.logic.peekStock());
    }
}
