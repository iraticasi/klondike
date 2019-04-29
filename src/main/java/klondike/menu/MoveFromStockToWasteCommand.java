package klondike.menu;

import klondike.Game;

public class MoveFromStockToWasteCommand extends Command {

    public MoveFromStockToWasteCommand(Game game) {
        super(Message.STOCK2WASTE_COMMAND.getMessage(), game);
    }

    @Override
    protected void execute() {
        this.game.moveFromStockToWaste();
    }
}
