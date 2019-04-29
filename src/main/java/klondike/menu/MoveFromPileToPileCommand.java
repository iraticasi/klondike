package klondike.menu;

import klondike.Game;

public class MoveFromPileToPileCommand extends Command {

    public MoveFromPileToPileCommand(Game game) {
        super(Message.PILE2PILE_COMMAND.getMessage(), game);
    }

    @Override
    protected void execute() {
        int originIndex = MenuIO.readPileIndex(true);
        int destinationIndex = MenuIO.readPileIndex(false);
        int numberOfCards = MenuIO.readNumberOfCards();
        this.game.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
    }
}
