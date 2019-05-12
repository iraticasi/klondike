package klondike.views.console;

import klondike.models.Game;
import klondike.utils.YesNoDialog;
import klondike.views.View;
import klondike.views.console.menu.PlayMenu;

public class ConsoleView extends View {

    PlayMenu playMenu;

    public ConsoleView(Game game) {
        super(game);
        this.playMenu = new PlayMenu(this.game);
    }

    @Override
    protected void start() {
        new GameView(this.game).writeln();
    }

    @Override
    protected void move() {
        this.playMenu.execute();
    }

    @Override
    protected boolean resume() {
        return new YesNoDialog().read(Message.RESUME);
    }
}
