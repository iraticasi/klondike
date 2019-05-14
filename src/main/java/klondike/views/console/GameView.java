package klondike.views.console;

import klondike.controllers.Controller;
import klondike.models.Game;
import klondike.models.Suit;
import klondike.utils.IO;

public class GameView {

    public GameView() {
    }

    public void writeln(Controller controller) {
        IO.writeln();
        IO.writeln(Message.GAME_TITLE);
        new StockView(controller.peekStock()).writeln();
        new WasteView(controller.peekWaste()).writeln();
        IO.writeln(Message.FOUNDATIONS_TITLE);
        for (Suit suit : Suit.values()) {
            new FoundationView(suit, controller.peekFoundation(suit)).writeln();
        }
        for (int i = 0; i < Game.NUMBER_OF_PILES; i++) {
            new PileView(i, controller.getPileCards(i)).writeln();
        }
    }
}
