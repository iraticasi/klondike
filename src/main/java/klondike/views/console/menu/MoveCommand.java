package klondike.views.console.menu;

import klondike.controllers.PlayController;
import klondike.models.Error;
import klondike.utils.IO;

public abstract class MoveCommand extends Command {

    protected MoveCommand(String title, PlayController playController) {
        super(title, playController);
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
