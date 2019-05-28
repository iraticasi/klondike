package klondike.views.console.menu;

import klondike.controllers.PlayController;

public class RedoCommand extends Command {

    public RedoCommand(PlayController playController) {
        super(CommandTitle.REDO_COMMAND.getTitle(), playController);
    }

    @Override
    protected void execute() {
        this.playController.redo();
    }

    @Override
    public boolean isActive() {
        return this.playController.redoable();
    }
}
