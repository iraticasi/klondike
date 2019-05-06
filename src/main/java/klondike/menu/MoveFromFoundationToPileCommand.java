package klondike.menu;

import klondike.Game;
import klondike.Pile;
import klondike.Suit;

public class MoveFromFoundationToPileCommand extends Command {

    public MoveFromFoundationToPileCommand(Game game) {
        super(Message.FOUNDATION2PILE_COMMAND.getMessage(), game);
    }

    @Override
    protected void execute() {
        Suit suit = Suit.read();
        int pileIndex = Pile.readIndex(false);
        this.game.moveFromFoundationToPile(suit, pileIndex);
    }
}
