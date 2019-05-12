package klondike.menu;

import klondike.Error;
import klondike.Game;

public class MoveFromWasteToStockCommand extends Command {

    public MoveFromWasteToStockCommand(Game game) {
        super(CommandTitle.WASTE2STOCK_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        return this.game.moveFromWasteToStock();
    }
}
