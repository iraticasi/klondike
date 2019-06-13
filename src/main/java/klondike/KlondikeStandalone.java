package klondike;

import klondike.controllers.Logic;
import klondike.controllers.implementation.LogicImplementation;

public class KlondikeStandalone extends Klondike {

    public static void main(String[] args) {
        new KlondikeStandalone().play();
    }

    @Override
    protected Logic createLogic() {
        return new LogicImplementation();
    }

}
