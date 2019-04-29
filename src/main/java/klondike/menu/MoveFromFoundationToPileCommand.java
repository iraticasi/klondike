package klondike.menu;

import klondike.Game;
import klondike.Suit;

public class MoveFromFoundationToPileCommand extends Command {

    public MoveFromFoundationToPileCommand(Game game) {
        super(Message.FOUNDATION2PILE_COMMAND.getMessage(), game);
    }

    @Override
    protected void execute() {
        Suit suit = MenuIO.readSuit();
        int pileIndex = MenuIO.readPileIndex(false);
        this.game.moveFromFoundationToPile(suit, pileIndex);
    }
}
