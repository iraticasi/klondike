package klondike.views.console;

import klondike.controllers.Controller;
import klondike.controllers.Logic;

public class WasteView extends CardStackView {

    public WasteView(Controller controller) {
        super(controller, Message.WASTE_TITLE);
    }

    public void writeln() {
        super.writeln(this.controller.peekWaste());
    }
}
