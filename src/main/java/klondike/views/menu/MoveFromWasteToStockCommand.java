package klondike.views.menu;

import klondike.models.Error;
import klondike.models.Game;

public class MoveFromWasteToStockCommand extends Command {

    public MoveFromWasteToStockCommand(Game game) {
        super(Message.WASTE2STOCK_COMMAND.getMessage(), game);
    }

    @Override
    protected Error move() {
        return this.game.moveFromWasteToStock();
    }
}
