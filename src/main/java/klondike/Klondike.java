package klondike;

import klondike.controllers.AcceptorController;
import klondike.controllers.Logic;
import klondike.views.View;
import klondike.views.console.ConsoleView;

public abstract class Klondike {

    private Logic logic;
    private View view;

    protected Klondike() {
        this.logic = new Logic(this.isStandalone());
        this.view = new ConsoleView();
    }

    protected void play() {
        AcceptorController acceptorController;
        do {
            acceptorController = this.logic.getController();
            this.view.interact(acceptorController);
        } while (acceptorController != null);
        if (!this.isStandalone()) {
            this.logic.close();
        }
    }

    protected abstract Boolean isStandalone();

}