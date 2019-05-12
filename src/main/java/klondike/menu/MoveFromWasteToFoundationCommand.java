package klondike.menu;

import klondike.Error;
import klondike.Game;
import klondike.Suit;

public class MoveFromWasteToFoundationCommand extends Command {

    public MoveFromWasteToFoundationCommand(Game game) {
        super(CommandTitle.WASTE2FOUNDATION_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        Suit suit = Suit.read();
        return this.game.moveFromWasteToFoundation(suit);
    }
}
