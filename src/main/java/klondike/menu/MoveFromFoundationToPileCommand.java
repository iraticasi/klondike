package klondike.menu;

import klondike.Game;
import klondike.Pile;
import klondike.Suit;
import klondike.Error;

public class MoveFromFoundationToPileCommand extends Command {

    public MoveFromFoundationToPileCommand(Game game) {
        super(CommandTitle.FOUNDATION2PILE_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        Suit suit = Suit.read();
        int pileIndex = Pile.readIndex(false);
        return this.game.moveFromFoundationToPile(suit, pileIndex);
    }
}
