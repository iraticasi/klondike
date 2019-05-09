package klondike.views;

import klondike.models.Game;
import klondike.models.Suit;
import klondike.utils.IO;

public class GameView {

    private final Game game;

    public GameView(Game game) {
        this.game = game;
    }

    public void writeln() {
        IO.writeln();
        IO.writeln(Message.GAME_TITLE);
        new StockView(this.game.getStock()).writeln();
        new WasteView(this.game.getWaste()).writeln();
        IO.writeln(Message.FOUNDATIONS_TITLE);
        for (Suit suit : Suit.values()) {
            new FoundationView(this.game.getFoundations().get(suit)).writeln();
        }
        for (int i = 0; i < Game.NUMBER_OF_PILES; i++) {
            IO.write(Message.PILE_TITLE.replace(Message.PILE_TAG, Integer.toString(i + 1)));
            new PileView(this.game.getPiles().get(i)).writeln();
        }
    }
}
