package klondike;

import klondike.controllers.Logic;
import klondike.views.View;
import klondike.views.console.ConsoleView;

public class Klondike {

    private Logic logic;
    private View view;

    private Klondike() {
        this.logic = new Logic();
        this.view = new ConsoleView(logic);
    }

    public static void main(String[] args) {
        new Klondike().play();
    }

    public void play() {
        view.interact();
    }
}