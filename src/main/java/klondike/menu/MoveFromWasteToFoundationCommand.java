package klondike.menu;

import klondike.Game;
import klondike.Suit;

public class MoveFromWasteToFoundationCommand extends Command {

    public MoveFromWasteToFoundationCommand(Game game) {
        super(Message.WASTE2FOUNDATION_COMMAND.getMessage(), game);
    }

    @Override
    protected int execute() {
        Suit suit = Suit.read();
        return this.game.moveFromWasteToFoundation(suit);
    }
}
