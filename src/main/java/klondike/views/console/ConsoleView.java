package klondike.views.console;

import klondike.controllers.Logic;
import klondike.utils.YesNoDialog;
import klondike.views.View;
import klondike.views.console.menu.PlayMenu;

public class ConsoleView extends View {

    private PlayMenu playMenu;

    public ConsoleView(Logic logic) {
        super(logic);
        this.playMenu = new PlayMenu(this.logic);
    }

    @Override
    protected void start() {
        new GameView(this.logic).writeln();
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
