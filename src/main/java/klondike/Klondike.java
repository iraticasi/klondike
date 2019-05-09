package klondike;

import klondike.models.Game;
import klondike.views.View;

public class Klondike {

    private View view;
    private Game game;

    private Klondike() {
        this.game = new Game();
        this.view = new View(this.game);
    }

    public static void main(String[] args) {
        new Klondike().play();
    }

    public void play() {
        view.interact();
    }
}