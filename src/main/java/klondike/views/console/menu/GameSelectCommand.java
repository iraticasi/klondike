package klondike.views.console.menu;

import klondike.controllers.StartController;
import klondike.utils.IO;

class GameSelectCommand extends Command {


    protected GameSelectCommand(String title, StartController startController) {
        super(title, startController);
    }

    @Override
    protected void execute() {
        IO.writeln(this.title);
        ((StartController) this.acceptorController).start(this.title);
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
