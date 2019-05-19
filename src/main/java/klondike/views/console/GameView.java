package klondike.views.console;

import klondike.controllers.Logic;
import klondike.models.Game;
import klondike.models.Suit;
import klondike.utils.IO;

public class GameView {


    private final Logic logic;

    public GameView(Logic logic) {
        this.logic = logic;
    }

    public void writeln() {
        IO.writeln();
        IO.writeln(Message.GAME_TITLE);
        new StockView(this.logic).writeln();
        new WasteView(this.logic).writeln();
        IO.writeln(Message.FOUNDATIONS_TITLE);
        for (Suit suit : Suit.values()) {
            new FoundationView(this.logic, suit).writeln();
        }
        IO.writeln(Message.PILES_TITLE);
        for (int i = 0; i < Game.NUMBER_OF_PILES; i++) {
            new PileView(this.logic, i).writeln();
        }
        IO.writeln(Message.GAME_END);
        IO.writeln();
    }
}
