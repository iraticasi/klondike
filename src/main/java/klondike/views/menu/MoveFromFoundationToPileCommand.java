package klondike.views.menu;

import klondike.models.Error;
import klondike.models.Game;
import klondike.models.Suit;
import klondike.views.PileView;
import klondike.views.SuitView;

public class MoveFromFoundationToPileCommand extends Command {

    public MoveFromFoundationToPileCommand(Game game) {
        super(Message.FOUNDATION2PILE_COMMAND.getMessage(), game);
    }

    @Override
    protected Error move() {
        Suit suit = SuitView.read();
        int pileIndex = PileView.readIndex(false);
        return this.game.moveFromFoundationToPile(suit, pileIndex);
    }
}
