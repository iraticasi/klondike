package klondike.views.console.menu;

import klondike.controllers.Logic;
import klondike.models.Error;

public class MoveFromWasteToStockCommand extends Command {

    public MoveFromWasteToStockCommand(Logic logic) {
        super(CommandTitle.WASTE2STOCK_COMMAND.getTitle(), logic);
    }

    @Override
    protected Error move() {
        return this.logic.moveFromWasteToStock();
    }
}
