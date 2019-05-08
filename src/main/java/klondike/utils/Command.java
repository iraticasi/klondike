package klondike.utils;

public abstract class Command {

    protected String title;

    protected Command(String title) {
        this.title = title;
    }

    protected abstract void execute();

    String getTitle() {
        return this.title;
    }

}
