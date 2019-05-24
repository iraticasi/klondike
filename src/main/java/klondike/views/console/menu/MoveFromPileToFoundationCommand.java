package klondike.views.console.menu;

import klondike.controllers.Logic;
import klondike.models.Error;
import klondike.models.Suit;

public class MoveFromPileToFoundationCommand extends Command {

    public MoveFromPileToFoundationCommand(Logic logic) {
        super(CommandTitle.PILE2FOUNDATION_COMMAND.getTitle(), logic);
    }

    @Override
    protected Error move() {
        int pileIndex = PileReader.readIndex(Message.ORIGIN);
        Suit suit = SuitReader.read();
        return this.logic.moveFromPileToFoundation(pileIndex, suit);
    }
}
