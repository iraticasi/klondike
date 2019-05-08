package klondike.menu;

import klondike.Error;
import klondike.Game;
import klondike.Pile;
import klondike.utils.ClosedInterval;
import klondike.utils.IO;

public class MoveFromPileToPileCommand extends Command {

    public MoveFromPileToPileCommand(Game game) {
        super(Message.PILE2PILE_COMMAND.getMessage(), game);
    }

    @Override
    protected Error move() {
        int originIndex = Pile.readIndex(true);
        int destinationIndex = Pile.readIndex(false);
        int numberOfCards = IO.readInt("How many cards do you want to move?: ", new ClosedInterval(1, 13));
        return this.game.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
    }
}
