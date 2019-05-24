package klondike.views.console.menu;

import klondike.models.Error;
import klondike.models.Game;
import klondike.models.Suit;

public class MoveFromPileToFoundationCommand extends Command {

    public MoveFromPileToFoundationCommand(Game game) {
        super(CommandTitle.PILE2FOUNDATION_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        int pileIndex = PileReader.readIndex(Message.ORIGIN);
        Suit suit = SuitReader.read();
        return this.game.moveFromPileToFoundation(pileIndex, suit);
    }
}
