package klondike.views.console.menu;

import klondike.controllers.PlayController;
import klondike.models.Error;
import klondike.models.Suit;

public class MoveFromWasteToFoundationCommand extends MoveCommand {

    public MoveFromWasteToFoundationCommand(PlayController playController) {
        super(CommandTitle.WASTE2FOUNDATION_COMMAND.getTitle(), playController);
    }

    @Override
    protected Error move() {
        Suit suit = SuitReader.read();
        return this.playController.moveFromWasteToFoundation(suit);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
