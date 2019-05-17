package klondike.menu;

import klondike.*;
import klondike.Error;

public class MoveFromFoundationToPileCommand extends Command {

    public MoveFromFoundationToPileCommand(Game game) {
        super(CommandTitle.FOUNDATION2PILE_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        Suit suit = Suit.read();
        int pileIndex = Pile.readIndex(Message.DESTINATION);
        return this.game.moveFromFoundationToPile(suit, pileIndex);
    }
}
