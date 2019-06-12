package klondike.distributed;

import klondike.distributed.dispatchers.DispatcherPrototype;

public class KlondikeServer {

    private DispatcherPrototype dispatcherPrototype;

    private LogicServer logicServer;

    private KlondikeServer() {
        this.dispatcherPrototype = new DispatcherPrototype();
        this.logicServer = new LogicServer(true);
        this.logicServer.createDispatchers(this.dispatcherPrototype);
    }

    private void serve() {
        this.dispatcherPrototype.serve();
    }

    public static void main(String[] args) {
        new KlondikeServer().serve();
    }

}
