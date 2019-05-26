package klondike;

import klondike.menu.PlayMenu;
import klondike.utils.YesNoDialog;

public class Klondike {

    private Game game;

    private PlayMenu playMenu;

    private Klondike() {
        this.game = new Game();
        this.playMenu = new PlayMenu(this.game);
    }

    public static void main(String[] args) {
        new Klondike().play();
    }

    public void play() {
        boolean resume;
        do {
            boolean finished;
            do {
                this.playMenu.execute();
                finished = this.game.isFinished();
            } while (!finished);
            resume = new YesNoDialog().read(Message.RESUME);
            if (resume) {
                this.game.clear();
            }
        } while (resume);
    }
}