package klondike.views.console.menu;

import klondike.controllers.MoveController;
import klondike.models.Error;
import klondike.models.Game;
import klondike.models.Suit;
import klondike.views.console.PileView;
import klondike.views.console.SuitView;

public class MoveFromFoundationToPileCommand extends Command {

    public MoveFromFoundationToPileCommand(MoveController moveController) {
        super(CommandTitle.FOUNDATION2PILE_COMMAND.getTitle(), moveController);
    }

    @Override
    protected Error move() {
        Suit suit = SuitView.read();
        int pileIndex = PileView.readIndex(false);
        return this.moveController.moveFromFoundationToPile(suit, pileIndex);
    }
}
