package klondike;

import klondike.controllers.AcceptorController;
import klondike.controllers.Logic;
import klondike.views.View;
import klondike.views.console.ConsoleView;

public abstract class Klondike {

    private Logic logic;
    private View view;

    protected Klondike() {
        this.logic = this.createLogic();
        this.view = new ConsoleView();
    }


    protected void play() {
        AcceptorController acceptorController;
        do {
            acceptorController = this.logic.getController();
            this.view.interact(acceptorController);
        } while (acceptorController != null);
    }

    protected abstract Logic createLogic();

}