package klondike.menu;

import klondike.Game;

public class MoveFromWasteToStockCommand extends Command {

    public MoveFromWasteToStockCommand(Game game) {
        super(Message.WASTE2STOCK_COMMAND.getMessage(), game);
    }

    @Override
    protected int execute() {
        return this.game.moveFromWasteToStock();
    }
}
