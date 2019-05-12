package klondike.views.console;

import klondike.controllers.MoveController;
import klondike.controllers.ResumeController;
import klondike.controllers.StartController;
import klondike.utils.YesNoDialog;
import klondike.views.View;
import klondike.views.console.menu.PlayMenu;

public class ConsoleView extends View {

    private PlayMenu playMenu;
    private GameView gameView;

    public ConsoleView(StartController startController, MoveController moveController, ResumeController resumeController) {
        super(startController, moveController, resumeController);
        this.playMenu = new PlayMenu(this.moveController);
        this.gameView = new GameView();

    }

    @Override
    protected void start() {
        this.gameView.writeln(startController);
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
