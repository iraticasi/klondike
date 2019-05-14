package klondike.views.console.menu;

import klondike.controllers.MoveController;
import klondike.models.Error;
import klondike.utils.IO;
import klondike.views.console.GameView;
import klondike.views.console.Message;

public abstract class Command extends klondike.utils.Command {

    protected MoveController moveController;

    protected Command(String title, MoveController moveController) {
        super(title);
        this.moveController = moveController;
    }

    @Override
    protected void execute() {
        Error error = this.move();
        if (error != null) {
            IO.writeError(Message.INVALID_MOVE, error.getMessage());
        } else {
            new GameView().writeln(moveController);
        }
    }

    protected abstract Error move();
}
