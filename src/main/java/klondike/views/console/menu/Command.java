package klondike.views.console.menu;

import klondike.controllers.Logic;
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
        new GameView(this.moveController).writeln();
        if (error != null) {
            IO.writeError(Message.INVALID_MOVE, error.getMessage());
        }
    }

    protected abstract Error move();
}
