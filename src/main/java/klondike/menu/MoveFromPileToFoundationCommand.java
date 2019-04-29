package klondike.menu;

import klondike.Game;
import klondike.Suit;

public class MoveFromPileToFoundationCommand extends Command {

    public MoveFromPileToFoundationCommand(Game game) {
        super(Message.PILE2FOUNDATION_COMMAND.getMessage(), game);
    }

    @Override
    protected void execute() {
        int pileIndex = MenuIO.readPileIndex(true);
        Suit suit = MenuIO.readSuit();
        this.game.moveFromPileToFoundation(pileIndex, suit);
    }
}
