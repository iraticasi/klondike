package klondike;

import klondike.menu.PlayMenu;

public class Klondike {

    private Game game;

    private Klondike() {
        game = new Game();
    }

    public static void main(String[] args) {
        new Klondike().play();
    }

    public void play() {
        boolean finished;
        do {
            game.writeln();
            new PlayMenu(game).execute();
            finished = game.isFinished();
        } while (!finished);
    }
}

