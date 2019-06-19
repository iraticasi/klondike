package klondike.views.console.menu;

import klondike.controllers.PlayController;
import klondike.models.Error;
import klondike.models.Suit;

public class MoveFromPileToFoundationCommand extends MoveCommand {

    public MoveFromPileToFoundationCommand(PlayController playController) {
        super(CommandTitle.PILE2FOUNDATION_COMMAND.getTitle(), playController);
    }

    @Override
    protected Error move() {
        int pileIndex = PileReader.readIndex(Message.ORIGIN);
        Suit suit = SuitReader.read();
        return ((PlayController) this.acceptorController).moveFromPileToFoundation(pileIndex, suit);
    }
}
