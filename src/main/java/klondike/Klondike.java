package klondike;

import klondike.utils.ClosedInterval;
import klondike.utils.IO;
import klondike.utils.YesNoDialog;

public class Klondike {

    private Game game;

    private Klondike() {
        game = new Game();
    }

    public static void main(String[] args) {
        new Klondike().play();
    }

    private static int readMove() {
        IO.writeln("1. Move from Stock to Waste");
        IO.writeln("2. Move from Waste to Stock");
        IO.writeln("3. Move from Waste to Foundation");
        IO.writeln("4. Move from Waste to Pile");
        IO.writeln("5. Move from Foundation to Pile");
        IO.writeln("6. Move from Pile to Foundation");
        IO.writeln("7. Move from Pile to Pile");
        return IO.readInt(Message.CHOOSE_OPTION, new ClosedInterval(1, 7));
    }

    private static int readNumberOfCards() {
        return IO.readInt(Message.READ_NUMBER_OF_CARDS);
    }

    public void play() {
        boolean finished;
        game.writeln();
        do {
            Error error = this.move();
            game.writeln();
            if (error != null) {
                IO.writeError(klondike.Message.INVALID_MOVE, error.getMessage());
            }
            finished = game.isFinished();
        } while (!finished);
        boolean resume = new YesNoDialog().read(Message.RESUME);
        if (resume) {
            new Klondike().play();
        }
    }

    private Error move() {
        int chosenMove = Klondike.readMove();
        Suit suit;
        int pileIndex;
        switch (chosenMove) {
            case 1:
                return this.game.moveFromStockToWaste();
            case 2:
                return this.game.moveFromWasteToStock();
            case 3:
                suit = Suit.read();
                return this.game.moveFromWasteToFoundation(suit);
            case 4:
                pileIndex = Pile.readIndex(Message.DESTINATION);
                return this.game.moveFromWasteToPile(pileIndex);
            case 5:
                suit = Suit.read();
                pileIndex = Pile.readIndex(Message.DESTINATION);
                return this.game.moveFromFoundationToPile(suit, pileIndex);
            case 6:
                pileIndex = Pile.readIndex(Message.ORIGIN);
                suit = Suit.read();
                return this.game.moveFromPileToFoundation(pileIndex, suit);
            case 7:
                int originIndex = Pile.readIndex(Message.ORIGIN);
                int destinationIndex = Pile.readIndex(Message.DESTINATION);
                int numberOfCards = Klondike.readNumberOfCards();
                return this.game.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
            default:
                return null;
        }
    }

}
