package klondike.views.console.menu;

import klondike.controllers.PlayController;

public class UndoCommand extends Command {

    public UndoCommand(PlayController playController) {
        super(CommandTitle.UNDO_COMMAND.getTitle(), playController);
    }

    @Override
    protected void execute() {
        this.playController.undo();
    }

    @Override
    public boolean isActive() {
        return this.playController.undoable();
    }
}
