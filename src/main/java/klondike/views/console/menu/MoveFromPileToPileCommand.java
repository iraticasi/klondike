package klondike.views.console.menu;


import klondike.controllers.PlayController;
import klondike.models.Error;
import klondike.utils.ClosedInterval;
import klondike.utils.IO;

public class MoveFromPileToPileCommand extends MoveCommand {

    public MoveFromPileToPileCommand(PlayController playController) {
        super(CommandTitle.PILE2PILE_COMMAND.getTitle(), playController);
    }

    @Override
    protected Error move() {
        int originIndex = PileReader.readIndex(Message.ORIGIN);
        int destinationIndex = PileReader.readIndex(Message.DESTINATION);
        int numberOfCards = IO.readInt(Message.READ_NUMBER_OF_CARDS, new ClosedInterval(1, 13));
        return this.playController.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
