package klondike.views;

import klondike.controllers.Logic;

public abstract class View {

    protected Logic logic;

    public View(Logic logic) {
        this.logic = logic;
    }

    public void interact() {
        boolean resume;
        do {
            this.start();
            boolean finished;
            do {
                this.move();
                finished = this.logic.isGameFinished();
            } while (!finished);
            resume = this.resume();
            if (resume) this.logic.resume();
        } while (resume);
    }

    protected abstract void start();

    protected abstract void move();

    protected abstract boolean resume();
}
