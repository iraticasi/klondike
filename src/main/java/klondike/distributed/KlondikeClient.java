package klondike.distributed;

import klondike.Klondike;

public class KlondikeClient extends Klondike {

    public static void main(String[] args) {
        new KlondikeClient().play();
    }

    @Override
    protected Boolean isStandalone() {
        return false;
    }

}
