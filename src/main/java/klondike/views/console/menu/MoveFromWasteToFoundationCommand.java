package klondike.views.console.menu;

import klondike.controllers.Logic;
import klondike.controllers.MoveController;
import klondike.models.Error;
import klondike.models.Suit;
import klondike.views.console.SuitView;

public class MoveFromWasteToFoundationCommand extends Command {

    public MoveFromWasteToFoundationCommand(MoveController moveController) {
        super(CommandTitle.WASTE2FOUNDATION_COMMAND.getTitle(), moveController);
    }

    @Override
    protected Error move() {
        Suit suit = SuitView.read();
        return this.moveController.moveFromWasteToFoundation(suit);
    }
}
