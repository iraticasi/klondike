package klondike.views.console.menu;

import klondike.models.Error;
import klondike.models.Game;
import klondike.utils.ClosedInterval;
import klondike.utils.IO;
import klondike.views.console.Message;
import klondike.views.console.PileView;

public class MoveFromPileToPileCommand extends Command {

    public MoveFromPileToPileCommand(Game game) {
        super(CommandTitle.PILE2PILE_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        int originIndex = PileView.readIndex(true);
        int destinationIndex = PileView.readIndex(false);
        int numberOfCards = IO.readInt(Message.READ_NUMBER_OF_CARDS, new ClosedInterval(1, 13));
        return this.game.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
    }
}
