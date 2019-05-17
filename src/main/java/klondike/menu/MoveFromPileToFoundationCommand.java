package klondike.menu;

import klondike.*;
import klondike.Error;

public class MoveFromPileToFoundationCommand extends Command {

    public MoveFromPileToFoundationCommand(Game game) {
        super(CommandTitle.PILE2FOUNDATION_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        int pileIndex = Pile.readIndex(Message.ORIGIN);
        Suit suit = Suit.read();
        return this.game.moveFromPileToFoundation(pileIndex, suit);
    }
}
