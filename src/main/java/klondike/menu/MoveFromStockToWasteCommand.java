package klondike.menu;

import klondike.Error;
import klondike.Game;

public class MoveFromStockToWasteCommand extends Command {

    public MoveFromStockToWasteCommand(Game game) {
        super(Message.STOCK2WASTE_COMMAND.getMessage(), game);
    }

    @Override
    protected Error move() {
        return this.game.moveFromStockToWaste();
    }
}
