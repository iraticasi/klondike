package klondike.menu;

import klondike.Error;
import klondike.Game;

public class MoveFromStockToWasteCommand extends Command {

    public MoveFromStockToWasteCommand(Game game) {
        super(CommandTitle.STOCK2WASTE_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        return this.game.moveFromStockToWaste();
    }
}
