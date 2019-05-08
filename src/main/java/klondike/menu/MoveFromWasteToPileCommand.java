package klondike.menu;

import klondike.Error;
import klondike.Game;
import klondike.Pile;

public class MoveFromWasteToPileCommand extends Command {

    public MoveFromWasteToPileCommand(Game game) {
        super(Message.WASTE2PILE_COMMAND.getMessage(), game);
    }

    @Override
    protected Error move() {
        int pileIndex = Pile.readIndex(false);
        return this.game.moveFromWasteToPile(pileIndex);
    }
}
