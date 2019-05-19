package klondike.views.console.menu;

import klondike.controllers.Logic;
import klondike.models.Error;
import klondike.models.Suit;
import klondike.views.console.Message;
import klondike.views.console.PileView;
import klondike.views.console.SuitView;

public class MoveFromPileToFoundationCommand extends Command {

    public MoveFromPileToFoundationCommand(Logic logic) {
        super(CommandTitle.PILE2FOUNDATION_COMMAND.getTitle(), logic);
    }

    @Override
    protected Error move() {
        int pileIndex = PileView.readIndex(Message.ORIGIN);
        Suit suit = SuitView.read();
        return this.logic.moveFromPileToFoundation(pileIndex, suit);
    }
}
