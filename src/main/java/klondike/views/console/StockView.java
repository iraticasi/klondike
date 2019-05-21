package klondike.views.console;

import klondike.controllers.Logic;

public class StockView extends CardStackView {

    public StockView(Logic logic) {
        super(logic, Message.STOCK_TITLE);
    }

    public void writeln() {
        super.writeln(this.logic.peekStock());
    }
}
