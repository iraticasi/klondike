package klondike.menu;

import klondike.Game;
import klondike.Pile;

public class MoveFromWasteToPileCommand extends Command {

    public MoveFromWasteToPileCommand(Game game) {
        super(Message.WASTE2PILE_COMMAND.getMessage(), game);
    }

    @Override
    protected void execute() {
        int pileIndex = Pile.readIndex(false);
        this.game.moveFromWasteToPile(pileIndex);
    }
}
