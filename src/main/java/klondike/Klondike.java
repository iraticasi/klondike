package klondike;

import klondike.menu.PlayMenu;
import klondike.utils.IO;
import klondike.utils.YesNoDialog;

public class Klondike {

    private static final String RESUME = "Do you want to resume?";

    private static final String INVALID_MOVE = "Invalid move";

    private Game game;

    private Klondike() {
        game = new Game();
    }

    public static void main(String[] args) {
        new Klondike().play();
    }

    public void play() {
        boolean resume;
        do {
            game.writeln();
            boolean finished;
            do {
                int error = new PlayMenu(game).execute();
                if (error != Error.NO_ERROR) {
                    IO.writeError(INVALID_MOVE, Error.values()[error].getMessage());
                } else {
                    game.writeln();
                }
                finished = game.isFinished();
            } while (!finished);
            resume = new YesNoDialog().read(RESUME);
            if (resume) {
                game.clear();
            }
        } while (resume);
    }
}

