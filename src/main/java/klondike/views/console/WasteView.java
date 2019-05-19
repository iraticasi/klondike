package klondike.views.console;

import klondike.controllers.Controller;
import klondike.models.Card;
import klondike.utils.IO;

public class WasteView extends CardStackView{

    private final Controller controller;

    public WasteView(Controller controller) {
        super(Message.WASTE_TITLE);
        this.controller = controller;
    }

    public void writeln() {
        super.writeln(this.controller.peekWaste());
    }
}
