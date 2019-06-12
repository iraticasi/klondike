package klondike.views.console;

import klondike.controllers.Controller;
import klondike.controllers.MoveController;
import klondike.controllers.ResumeController;
import klondike.controllers.StartController;
import klondike.utils.YesNoDialog;
import klondike.views.View;
import klondike.views.console.menu.PlayMenu;

public class ConsoleView extends View {

    @Override
    public void interact(Controller controller) {
        if (controller instanceof StartController) {
            this.start((StartController) controller);
        } else {
            if (controller instanceof MoveController) {
                this.move((MoveController) controller);
            } else {
                this.resume((ResumeController) controller);
            }
        }
    }

    private void resume(ResumeController resumeController) {
        resumeController.resume(new YesNoDialog().read(Message.RESUME));

    }

    private void move(MoveController moveController) {
        new PlayMenu(moveController).execute();
        new GameView(moveController).writeln();
    }

    private void start(StartController startController) {
        startController.start();
        new GameView(startController).writeln();
    }

}
