package klondike;

import klondike.menu.PlayMenu;
import klondike.utils.IO;
import klondike.utils.YesNoDialog;

public class Klondike {

    private static final String RESUME = "Do you want to resume?";

    private Game game;

    private Klondike() {
        this.game = new Game();
    }

    public static void main(String[] args) {
        new Klondike().play();
    }

    public void play() {
        boolean resume;
        do {
            this.game.writeln();
            boolean finished;
            do {
                this.game.writeln();
                new PlayMenu(this.game).execute();
                finished = this.game.isFinished();
            } while (!finished);
            resume = new YesNoDialog().read(Klondike.RESUME);
            if (resume) {
                this.game.clear();
            }
        } while (resume);
    }
}

