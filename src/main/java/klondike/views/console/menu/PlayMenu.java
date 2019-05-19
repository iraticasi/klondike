package klondike.views.console.menu;

import klondike.controllers.Logic;
import klondike.utils.Menu;

public class PlayMenu extends Menu {

    public PlayMenu(Logic logic) {
        this.addCommand(new MoveFromStockToWasteCommand(logic));
        this.addCommand(new MoveFromWasteToStockCommand(logic));
        this.addCommand(new MoveFromWasteToFoundationCommand(logic));
        this.addCommand(new MoveFromWasteToPileCommand(logic));
        this.addCommand(new MoveFromFoundationToPileCommand(logic));
        this.addCommand(new MoveFromPileToFoundationCommand(logic));
        this.addCommand(new MoveFromPileToPileCommand(logic));

    }

}
