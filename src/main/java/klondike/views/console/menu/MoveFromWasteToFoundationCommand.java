package klondike.views.console.menu;

import klondike.models.Error;
import klondike.models.Game;
import klondike.models.Suit;
import klondike.views.console.SuitView;

public class MoveFromWasteToFoundationCommand extends Command {

    public MoveFromWasteToFoundationCommand(Game game) {
        super(CommandTitle.WASTE2FOUNDATION_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        Suit suit = SuitView.read();
        return this.game.moveFromWasteToFoundation(suit);
    }
}
