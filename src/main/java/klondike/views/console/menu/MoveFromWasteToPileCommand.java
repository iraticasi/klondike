package klondike.views.console.menu;

import klondike.models.Error;
import klondike.models.Game;
import klondike.views.console.PileView;

public class MoveFromWasteToPileCommand extends Command {

    public MoveFromWasteToPileCommand(Game game) {
        super(CommandTitle.WASTE2PILE_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        int pileIndex = PileView.readIndex(false);
        return this.game.moveFromWasteToPile(pileIndex);
    }
}
