package klondike.views.console.menu;

import klondike.controllers.PlayController;

public abstract class Command extends klondike.utils.Command {

    protected PlayController playController;

    protected Command(String title, PlayController playController) {
        super(title);
        this.playController = playController;
    }

}
