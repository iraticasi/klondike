package klondike.views.console.menu;

import klondike.controllers.PlayController;

class ExitCommand extends Command {

    protected ExitCommand(PlayController playController) {
        super(CommandTitle.EXIT_COMMAND.getTitle(), playController);
    }

    @Override
    protected void execute() {
        ((PlayController) this.acceptorController).next();
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
