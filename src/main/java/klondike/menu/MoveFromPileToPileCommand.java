package klondike.menu;

import klondike.Error;
import klondike.Game;
import klondike.Pile;
import klondike.utils.ClosedInterval;
import klondike.utils.IO;

public class MoveFromPileToPileCommand extends Command {

    public MoveFromPileToPileCommand(Game game) {
        super(CommandTitle.PILE2PILE_COMMAND.getTitle(), game);
    }

    @Override
    protected Error move() {
        int originIndex = Pile.readIndex(true);
        int destinationIndex = Pile.readIndex(false);
        int numberOfCards = IO.readInt(klondike.Message.READ_NUMBER_OF_CARDS , new ClosedInterval(1, 13));
        return this.game.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
    }
}
