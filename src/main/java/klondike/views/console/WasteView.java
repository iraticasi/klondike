package klondike.views.console;

import klondike.controllers.Logic;

public class WasteView extends CardStackView {

    public WasteView(Logic logic) {
        super(logic, Message.WASTE_TITLE);
    }

    public void writeln() {
        super.writeln(this.logic.peekWaste());
    }
}
