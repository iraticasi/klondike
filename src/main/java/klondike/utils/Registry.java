package klondike.models;

import java.util.ArrayList;

class Registry {

    private Game game;

    private int undoCount;

    private ArrayList<Memento> mementoList;

    Registry(Game game) {
        this.game = game;
        this.undoCount = 0;
        this.mementoList = new ArrayList<>();
        this.mementoList.add(undoCount, this.game.createMemento());
    }

    void registry() {
        for (int i = 0; i < this.undoCount; i++) {
            this.mementoList.remove(0);
        }
        this.undoCount = 0;
        this.mementoList.add(this.undoCount, this.game.createMemento());
    }

    void undo(Game game) {
        this.undoCount++;
        game.restore(this.mementoList.get(this.undoCount));
    }

    void redo(Game game) {
        this.undoCount--;
        game.restore(this.mementoList.get(this.undoCount));
    }

    boolean undoable() {
        return this.undoCount < this.mementoList.size() - 1;
    }

    boolean redoable() {
        return this.undoCount >= 1;
    }

    void reset() {
        this.mementoList = new ArrayList<Memento>();
        this.mementoList.add(undoCount, this.game.createMemento());
        this.undoCount = 0;
    }

}
