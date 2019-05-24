package klondike.views.console;

import klondike.controllers.MoveController;
import klondike.controllers.ResumeController;
import klondike.controllers.StartController;
import klondike.utils.YesNoDialog;
import klondike.views.View;
import klondike.views.console.menu.PlayMenu;

public class ConsoleView extends View {

    private PlayMenu playMenu;

    public ConsoleView(StartController startController, MoveController moveController, ResumeController resumeController) {
        super(startController, moveController, resumeController);
        this.playMenu = new PlayMenu(this.moveController);
    }

    @Override
    protected void start() {
        new GameView(this.startController).writeln();
    }

    @Override
    protected void move() {
        this.playMenu.execute();
        new GameView(this.moveController).writeln();
    }

    @Override
    protected boolean resume() {
        return new YesNoDialog().read(Message.RESUME);
    }
}
