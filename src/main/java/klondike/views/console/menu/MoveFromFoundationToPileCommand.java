package klondike.views.console.menu;

import klondike.models.Error;
import klondike.models.Game;
import klondike.models.Suit;
import klondike.views.console.PileView;
import klondike.views.console.SuitView;

public class MoveFromFoundationToPileCommand extends Command {

    public MoveFromFoundationToPileCommand(Game game) {
        super(CommandTitle.FOUNDATION2PILE_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        Suit suit = SuitView.read();
        int pileIndex = PileView.readIndex(false);
        return this.game.moveFromFoundationToPile(suit, pileIndex);
    }
}
