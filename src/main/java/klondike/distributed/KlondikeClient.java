package klondike.distributed;

import klondike.Klondike;

public class KlondikeClient extends Klondike {

    @Override
    protected Boolean isStandalone() {
        return false;
    }

    public static void main(String[] args) {
        new KlondikeClient().play();
    }

}
