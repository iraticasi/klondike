package klondike;

import klondike.menu.PlayMenu;
import klondike.utils.YesNoDialog;

public class Klondike {

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
            boolean finished;
            do {
                game.writeln();
                new PlayMenu(game).execute();
                finished = game.isFinished();
            } while (!finished);
            resume = new YesNoDialog().read("Do you want to resume?");
            if (resume) {
                game.clear();
            }
        } while (resume);
    }
}

