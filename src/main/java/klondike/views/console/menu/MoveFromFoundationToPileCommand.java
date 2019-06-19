package klondike.views.console.menu;

import klondike.controllers.PlayController;
import klondike.models.Error;
import klondike.models.Suit;

public class MoveFromFoundationToPileCommand extends MoveCommand {

    public MoveFromFoundationToPileCommand(PlayController playController) {
        super(CommandTitle.FOUNDATION2PILE_COMMAND.getTitle(), playController);
    }

    @Override
    protected Error move() {
        Suit suit = SuitReader.read();
        int pileIndex = PileReader.readIndex(Message.DESTINATION);
        return ((PlayController) this.acceptorController).moveFromFoundationToPile(suit, pileIndex);
    }
}
