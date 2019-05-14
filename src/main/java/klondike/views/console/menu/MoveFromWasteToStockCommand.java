package klondike.views.console.menu;

import klondike.controllers.MoveController;
import klondike.models.Error;

public class MoveFromWasteToStockCommand extends Command {

    public MoveFromWasteToStockCommand(MoveController moveController) {
        super(CommandTitle.WASTE2STOCK_COMMAND.getTitle(), moveController);
    }

    @Override
    protected Error move() {
        return this.moveController.moveFromWasteToStock();
    }
}
