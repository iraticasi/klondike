package klondike.views;

import klondike.models.Game;

public abstract class View {

    protected Game game;

    public View(Game game) {
        this.game = game;
    }

    public void interact() {
        boolean resume;
        do {
            this.start();
            boolean finished;
            do {
                this.move();
                finished = this.game.isFinished();
            } while (!finished);
            resume = this.resume();
            if (resume) {
                this.game.clear();
            }
        } while (resume);
    }

    protected abstract void start();

    protected abstract void move();

    protected abstract boolean resume();
}
