package klondike.views.console.menu;

import klondike.controllers.MoveController;
import klondike.models.Error;
import klondike.models.Game;
import klondike.models.Suit;
import klondike.views.console.PileView;
import klondike.views.console.SuitView;

public class MoveFromPileToFoundationCommand extends Command {

    public MoveFromPileToFoundationCommand(MoveController moveController) {
        super(CommandTitle.PILE2FOUNDATION_COMMAND.getTitle(), moveController);
    }

    @Override
    protected Error move() {
        int pileIndex = PileView.readIndex(true);
        Suit suit = SuitView.read();
        return this.moveController.moveFromPileToFoundation(pileIndex, suit);
    }
}
