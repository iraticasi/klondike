package klondike.views.console.menu;

import klondike.controllers.StartController;

class NewGameCommand extends Command {

    protected NewGameCommand(StartController startController) {
        super(CommandTitle.NEWGAME_COMMAND.getTitle(), startController);
    }

    @Override
    protected void execute() {
        ((StartController) this.acceptorController).start();
    }

    @Override
    public boolean isActive() {
        return true;
    }

}