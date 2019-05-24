package klondike.views.console.menu;

import klondike.models.Error;
import klondike.models.Game;
import klondike.models.Suit;

public class MoveFromFoundationToPileCommand extends Command {

    public MoveFromFoundationToPileCommand(Game game) {
        super(CommandTitle.FOUNDATION2PILE_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        Suit suit = SuitReader.read();
        int pileIndex = PileReader.readIndex(Message.DESTINATION);
        return this.game.moveFromFoundationToPile(suit, pileIndex);
    }
}
