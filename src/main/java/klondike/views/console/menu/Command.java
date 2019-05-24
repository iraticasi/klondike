package klondike.views.console.menu;

import klondike.controllers.Logic;
import klondike.models.Error;
import klondike.utils.IO;

public abstract class Command extends klondike.utils.Command {

    protected Logic logic;

    protected Command(String title, Logic logic) {
        super(title);
        this.logic = logic;
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
