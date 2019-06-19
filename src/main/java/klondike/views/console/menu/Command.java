package klondike.views.console.menu;

import klondike.controllers.AcceptorController;

public abstract class Command extends klondike.utils.Command {

    protected AcceptorController acceptorController;

    protected Command(String title, AcceptorController acceptorController) {
        super(title);
        this.acceptorController = acceptorController;
    }

}
