package klondike.views.console;

import klondike.controllers.AcceptorController;
import klondike.controllers.PlayController;
import klondike.controllers.ResumeController;
import klondike.controllers.StartController;
import klondike.utils.YesNoDialog;
import klondike.views.View;
import klondike.views.console.menu.PlayMenu;

public class ConsoleView extends View {

    @Override
    public void interact(AcceptorController acceptorController) {
        acceptorController.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        startController.start();
        new GameView(startController).writeln();
    }

    @Override
    public void visit(PlayController playController) {
        new PlayMenu(playController).execute();
        new GameView(playController).writeln();
    }

    @Override
    public void visit(ResumeController resumeController) {
        resumeController.resume(new YesNoDialog().read(Message.RESUME));
    }
}
