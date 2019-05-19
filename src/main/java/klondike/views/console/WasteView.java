package klondike.views.console;

import klondike.controllers.Logic;

public class WasteView extends CardStackView {

    private final Logic logic;

    public WasteView(Logic logic) {
        super(Message.WASTE_TITLE);
        this.logic = logic;
    }

    public void writeln() {
        super.writeln(this.logic.peekWaste());
    }
}
