package klondike.views;

import klondike.models.Game;
import klondike.utils.YesNoDialog;
import klondike.views.menu.PlayMenu;

public class View {

    protected Game game;

    public View(Game game) {
        this.game = game;
    }

    public void interact() {
        PlayMenu playMenu = new PlayMenu(this.game);
        boolean resume;
        do {
            boolean finished;
            do {
                playMenu.execute();
                finished = this.game.isFinished();
            } while (!finished);
            resume = new YesNoDialog().read(Message.RESUME);
            if (resume) {
                this.game.clear();
            }
        } while (resume);
    }

}
