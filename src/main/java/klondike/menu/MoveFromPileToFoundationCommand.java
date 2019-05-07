package klondike.menu;

import klondike.Game;
import klondike.Pile;
import klondike.Suit;

public class MoveFromPileToFoundationCommand extends Command {

    public MoveFromPileToFoundationCommand(Game game) {
        super(Message.PILE2FOUNDATION_COMMAND.getMessage(), game);
    }

    @Override
    protected int execute() {
        int pileIndex = Pile.readIndex(true);
        Suit suit = Suit.read();
        return this.game.moveFromPileToFoundation(pileIndex, suit);
    }
}
