package klondike.views.console.menu;

import klondike.models.Error;
import klondike.models.Game;
import klondike.models.Suit;
import klondike.views.console.PileView;
import klondike.views.console.SuitView;

public class MoveFromPileToFoundationCommand extends Command {

    public MoveFromPileToFoundationCommand(Game game) {
        super(CommandTitle.PILE2FOUNDATION_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        int pileIndex = PileView.readIndex(true);
        Suit suit = SuitView.read();
        return this.game.moveFromPileToFoundation(pileIndex, suit);
    }
}
