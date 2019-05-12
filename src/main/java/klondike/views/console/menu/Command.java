package klondike.views.console.menu;

import klondike.models.Error;
import klondike.models.Game;
import klondike.utils.IO;
import klondike.views.console.GameView;
import klondike.views.console.Message;

public abstract class Command extends klondike.utils.Command {

    protected Game game;

    protected Command(String title, Game game) {
        super(title);
        this.game = game;
    }

    @Override
    protected void execute() {
        Error error = this.move();
        if (error != null) {
            IO.writeError(Message.INVALID_MOVE, error.getMessage());
        } else {
            new GameView(this.game).writeln();
        }
    }

    protected abstract Error move();
}
