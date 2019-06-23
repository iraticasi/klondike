package klondike.models.DAO;

import klondike.models.Game;
import klondike.models.Suit;

import java.io.BufferedReader;
import java.io.FileWriter;

public class GameDAO implements DAO {

    private final Game game;

    GameDAO(Game game) {
        this.game = game;
    }

    public void save(FileWriter fileWriter) {
        new CardStackDAO(this.game.getStock()).save(fileWriter);
        new CardStackDAO(this.game.getWaste()).save(fileWriter);
        for (Suit suit : Suit.values()) {
            new CardStackDAO(this.game.getFoundation(suit)).save(fileWriter);
        }
        for (int i = 0; i < Game.NUMBER_OF_PILES; i++) {
            new PileDAO(game.getPile(i)).save(fileWriter);
        }
    }

    public void load(BufferedReader bufferedReader) {
        new CardStackDAO(this.game.getStock()).load(bufferedReader);
        new CardStackDAO(this.game.getWaste()).load(bufferedReader);
        for (Suit suit : Suit.values()) {
            new CardStackDAO(this.game.getFoundation(suit)).load(bufferedReader);
        }
        for (int i = 0; i < Game.NUMBER_OF_PILES; i++) {
            new PileDAO(game.getPile(i)).load(bufferedReader);
        }
    }
}
