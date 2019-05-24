package klondike.views.console.menu;

import klondike.controllers.Logic;
import klondike.models.Error;
import klondike.utils.ClosedInterval;
import klondike.utils.IO;

public class MoveFromPileToPileCommand extends Command {

    public MoveFromPileToPileCommand(Logic logic) {
        super(CommandTitle.PILE2PILE_COMMAND.getTitle(), logic);
    }

    @Override
    protected Error move() {
        int originIndex = PileReader.readIndex(Message.ORIGIN);
        int destinationIndex = PileReader.readIndex(Message.DESTINATION);
        int numberOfCards = IO.readInt(Message.READ_NUMBER_OF_CARDS, new ClosedInterval(1, 13));
        return this.logic.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
    }
}
