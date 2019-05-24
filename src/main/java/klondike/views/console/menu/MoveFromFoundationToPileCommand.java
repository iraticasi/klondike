package klondike.views.console.menu;

import klondike.controllers.Logic;
import klondike.models.Error;
import klondike.models.Suit;

public class MoveFromFoundationToPileCommand extends Command {

    public MoveFromFoundationToPileCommand(Logic logic) {
        super(CommandTitle.FOUNDATION2PILE_COMMAND.getTitle(), logic);
    }

    @Override
    protected Error move() {
        Suit suit = SuitReader.read();
        int pileIndex = PileReader.readIndex(Message.DESTINATION);
        return this.logic.moveFromFoundationToPile(suit, pileIndex);
    }
}
