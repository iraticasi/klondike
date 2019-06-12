package klondike.views.console.menu;

import klondike.controllers.PlayController;
import klondike.models.Error;

public class MoveFromWasteToStockCommand extends MoveCommand {

    public MoveFromWasteToStockCommand(PlayController playController) {
        super(CommandTitle.WASTE2STOCK_COMMAND.getTitle(), playController);
    }

    @Override
    protected Error move() {
        return this.playController.moveFromWasteToStock();
    }
}
