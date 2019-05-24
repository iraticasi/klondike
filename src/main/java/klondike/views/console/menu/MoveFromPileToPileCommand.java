package klondike.views.console.menu;

import klondike.models.Error;
import klondike.models.Game;
import klondike.utils.ClosedInterval;
import klondike.utils.IO;

public class MoveFromPileToPileCommand extends Command {

    public MoveFromPileToPileCommand(Game game) {
        super(CommandTitle.PILE2PILE_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        int originIndex = PileReader.readIndex(Message.ORIGIN);
        int destinationIndex = PileReader.readIndex(Message.DESTINATION);
        int numberOfCards = IO.readInt(Message.READ_NUMBER_OF_CARDS, new ClosedInterval(1, 13));
        return this.game.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
    }
}
