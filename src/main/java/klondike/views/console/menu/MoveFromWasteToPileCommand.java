package klondike.views.console.menu;

import klondike.controllers.Logic;
import klondike.models.Error;
import klondike.views.console.Message;
import klondike.views.console.PileView;

public class MoveFromWasteToPileCommand extends Command {

    public MoveFromWasteToPileCommand(Logic logic) {
        super(CommandTitle.WASTE2PILE_COMMAND.getTitle(), logic);
    }

    @Override
    protected Error move() {
        int pileIndex = PileView.readIndex(Message.DESTINATION);
        return this.logic.moveFromWasteToPile(pileIndex);
    }
}
