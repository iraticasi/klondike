package klondike;

import klondike.controllers.AcceptorController;
import klondike.controllers.Logic;
import klondike.views.View;
import klondike.views.console.ConsoleView;

public class Klondike {

    private Logic logic;
    private View view;

    private Klondike() {
        this.logic = new Logic();
        this.view = new ConsoleView();
    }

    public static void main(String[] args) {
        new Klondike().play();
    }

    public void play() {
        AcceptorController acceptorController;
        do {
            acceptorController = this.logic.getController();
            this.view.interact(acceptorController);
        } while (acceptorController != null);
    }
}