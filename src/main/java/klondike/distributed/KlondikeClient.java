package klondike.distributed;

import klondike.Klondike;
import klondike.controllers.Logic;

public class KlondikeClient extends Klondike {

    private LogicProxy logicProxy;

    public static void main(String[] args) {
        new KlondikeClient().play();
    }

    @Override
    protected Logic createLogic() {
        this.logicProxy = new LogicProxy();
        return this.logicProxy;
    }

    @Override
    protected void play() {
        super.play();
        this.logicProxy.close();
    }

}
