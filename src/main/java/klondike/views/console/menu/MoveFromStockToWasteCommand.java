package klondike.views.console.menu;

import klondike.controllers.Logic;
import klondike.models.Error;

public class MoveFromStockToWasteCommand extends Command {

    public MoveFromStockToWasteCommand(Logic logic) {
        super(CommandTitle.STOCK2WASTE_COMMAND.getTitle(), logic);
    }

    @Override
    protected Error move() {
        return this.logic.moveFromStockToWaste();
    }
}
