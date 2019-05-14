package klondike.views.console.menu;

import klondike.controllers.MoveController;
import klondike.models.Error;

public class MoveFromStockToWasteCommand extends Command {

    public MoveFromStockToWasteCommand(MoveController moveController) {
        super(CommandTitle.STOCK2WASTE_COMMAND.getTitle(), moveController);
    }

    @Override
    protected Error move() {
        return this.moveController.moveFromStockToWaste();
    }
}
