package klondike.views.console;

import klondike.controllers.Controller;
import klondike.models.Card;
import klondike.models.CardStack;
import klondike.utils.IO;

public class StockView extends CardStackView {

    private final Controller controller;

    public StockView(Controller controller) {
        super(Message.STOCK_TITLE);
        this.controller = controller;
    }

    public void writeln() {
        super.writeln(this.controller.peekStock());
    }
}
