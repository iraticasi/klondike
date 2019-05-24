package klondike.views.console.menu;

import klondike.controllers.MoveController;
import klondike.models.Error;
import klondike.utils.IO;

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
        }
    }

    protected abstract Error move();
}
