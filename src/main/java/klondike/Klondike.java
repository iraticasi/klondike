package klondike;

import klondike.menu.PlayMenu;
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
        PlayMenu playMenu = new PlayMenu(this.game);
        boolean resume;
        do {
            boolean finished;
            do {
                playMenu.execute();
                finished = this.game.isFinished();
            } while (!finished);
            resume = new YesNoDialog().read(Klondike.RESUME);
            if (resume) {
                this.game.clear();
            }
        } while (resume);
    }
}