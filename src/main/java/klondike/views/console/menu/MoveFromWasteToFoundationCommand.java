package klondike.views.console.menu;

import klondike.controllers.MoveController;
import klondike.models.Error;
import klondike.models.Suit;

public class MoveFromWasteToFoundationCommand extends Command {

    public MoveFromWasteToFoundationCommand(MoveController moveController) {
        super(CommandTitle.WASTE2FOUNDATION_COMMAND.getTitle(), moveController);
    }

    @Override
    protected Error move() {
        Suit suit = SuitReader.read();
        return this.moveController.moveFromWasteToFoundation(suit);
    }
}
