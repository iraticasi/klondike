package klondike.views.console.menu;

import klondike.controllers.Logic;
import klondike.models.Error;
import klondike.models.Suit;
import klondike.views.console.Message;
import klondike.views.console.PileView;
import klondike.views.console.SuitView;

public class MoveFromFoundationToPileCommand extends Command {

    public MoveFromFoundationToPileCommand(Logic logic) {
        super(CommandTitle.FOUNDATION2PILE_COMMAND.getTitle(), logic);
    }

    @Override
    protected Error move() {
        Suit suit = SuitView.read();
        int pileIndex = PileView.readIndex(Message.DESTINATION);
        return this.logic.moveFromFoundationToPile(suit, pileIndex);
    }
}
