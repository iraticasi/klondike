package klondike.views.console.menu;

import klondike.models.Error;
import klondike.models.Game;

public class MoveFromWasteToStockCommand extends Command {

    public MoveFromWasteToStockCommand(Game game) {
        super(CommandTitle.WASTE2STOCK_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        return this.game.moveFromWasteToStock();
    }
}
