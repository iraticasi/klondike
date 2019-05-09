package klondike.views.menu;

import klondike.models.Error;
import klondike.models.Game;
import klondike.views.PileView;

public class MoveFromWasteToPileCommand extends Command {

    public MoveFromWasteToPileCommand(Game game) {
        super(Message.WASTE2PILE_COMMAND.getMessage(), game);
    }

    @Override
    protected Error move() {
        int pileIndex = PileView.readIndex(false);
        return this.game.moveFromWasteToPile(pileIndex);
    }
}
