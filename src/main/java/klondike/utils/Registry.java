package klondike.utils;

import java.util.ArrayList;

public class Registry {

    private final Originator originator;

    private int undoCount;

    private ArrayList<Memento> mementoList;

    public Registry(Originator originator) {
        this.originator = originator;
        this.undoCount = 0;
        this.mementoList = new ArrayList<>();
        this.mementoList.add(undoCount, this.originator.createMemento());
    }

    public void registry() {
        for (int i = 0; i < this.undoCount; i++) {
            this.mementoList.remove(0);
        }
        this.undoCount = 0;
        this.mementoList.add(this.undoCount, this.originator.createMemento());
    }

    public void undo(Originator originator) {
        this.undoCount++;
        originator.restore(this.mementoList.get(this.undoCount));
    }

    public void redo(Originator originator) {
        this.undoCount--;
        originator.restore(this.mementoList.get(this.undoCount));
    }

    public boolean undoable() {
        return this.undoCount < this.mementoList.size() - 1;
    }

    public boolean redoable() {
        return this.undoCount >= 1;
    }

    public void reset() {
        this.mementoList = new ArrayList<>();
        this.undoCount = 0;
        this.mementoList.add(undoCount, this.originator.createMemento());
    }
}
