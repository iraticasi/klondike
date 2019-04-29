package klondike.menu;

import klondike.Game;

public class MoveFromWasteToPileCommand extends Command {

    public MoveFromWasteToPileCommand(Game game) {
        super(Message.WASTE2PILE_COMMAND.getMessage(), game);
    }

    @Override
    protected void execute() {
        int pileIndex = MenuIO.readPileIndex(false);
        this.game.moveFromWasteToPile(pileIndex);
    }
}
