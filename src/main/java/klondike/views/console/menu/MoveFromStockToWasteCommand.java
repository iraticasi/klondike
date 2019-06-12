package klondike.views.console.menu;

import klondike.controllers.PlayController;
import klondike.models.Error;

public class MoveFromStockToWasteCommand extends MoveCommand {

    public MoveFromStockToWasteCommand(PlayController playController) {
        super(CommandTitle.STOCK2WASTE_COMMAND.getTitle(), playController);
    }

    @Override
    protected Error move() {
        return this.playController.moveFromStockToWaste();
    }
}
