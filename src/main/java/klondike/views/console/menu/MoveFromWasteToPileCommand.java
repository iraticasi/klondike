package klondike.views.console.menu;

import klondike.controllers.Logic;
import klondike.models.Error;

public class MoveFromWasteToPileCommand extends Command {

    public MoveFromWasteToPileCommand(Logic logic) {
        super(CommandTitle.WASTE2PILE_COMMAND.getTitle(), logic);
    }

    @Override
    protected Error move() {
        int pileIndex = PileReader.readIndex(Message.DESTINATION);
        return this.logic.moveFromWasteToPile(pileIndex);
    }
}
