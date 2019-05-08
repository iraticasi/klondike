package klondike.menu;

import klondike.Error;
import klondike.Game;

public class MoveFromWasteToStockCommand extends Command {

    public MoveFromWasteToStockCommand(Game game) {
        super(Message.WASTE2STOCK_COMMAND.getMessage(), game);
    }

    @Override
    protected Error move() {
        return this.game.moveFromWasteToStock();
    }
}
