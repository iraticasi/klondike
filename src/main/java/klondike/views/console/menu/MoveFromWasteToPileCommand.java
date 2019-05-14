package klondike.views.console.menu;

import klondike.controllers.MoveController;
import klondike.models.Error;
import klondike.views.console.PileView;

public class MoveFromWasteToPileCommand extends Command {

    public MoveFromWasteToPileCommand(MoveController moveController) {
        super(CommandTitle.WASTE2PILE_COMMAND.getTitle(), moveController);
    }

    @Override
    protected Error move() {
        int pileIndex = PileView.readIndex(false);
        return this.moveController.moveFromWasteToPile(pileIndex);
    }
}
