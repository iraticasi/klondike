package klondike;

public class KlondikeStandalone extends Klondike {

    public static void main(String[] args) {
        new KlondikeStandalone().play();
    }

    @Override
    protected Boolean isStandalone() {
        return true;
    }
}
