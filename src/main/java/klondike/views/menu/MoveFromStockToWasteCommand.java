package klondike.views.menu;

import klondike.models.Error;
import klondike.models.Game;

public class MoveFromStockToWasteCommand extends Command {

    public MoveFromStockToWasteCommand(Game game) {
        super(Message.STOCK2WASTE_COMMAND.getMessage(), game);
    }

    @Override
    protected Error move() {
        return this.game.moveFromStockToWaste();
    }
}
