package klondike.views.console;

import klondike.controllers.Controller;
import klondike.models.Card;
import klondike.utils.IO;

public class WasteView extends CardStackView{


    public WasteView(Controller controller) {
        super(controller, Message.WASTE_TITLE);
    }

    public void writeln() {
        super.writeln(this.controller.peekWaste());
    }
}
