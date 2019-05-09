package klondike.menu;

import klondike.Error;
import klondike.Game;
import klondike.utils.IO;

public abstract class Command extends klondike.utils.Command {

    protected Game game;

    protected Command(String title, Game game) {
        super(title);
        this.game = game;
    }

    @Override
    protected void execute() {
        Error error = this.move();
        if (error!=null){
            IO.writeError(klondike.Message.INVALID_MOVE, error.getMessage());
        }else{
            this.game.writeln();
        }
    }

    protected abstract Error move();
}
