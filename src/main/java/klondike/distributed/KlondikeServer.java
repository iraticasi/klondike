package klondike.distributed;

import klondike.distributed.dispatchers.DispatcherPrototype;

public class KlondikeServer {

    private DispatcherPrototype dispatcherPrototype;

    private LogicImplementationServer logicServer;

    private KlondikeServer() {
        this.dispatcherPrototype = new DispatcherPrototype();
        this.logicServer = new LogicImplementationServer();
        this.logicServer.createDispatchers(this.dispatcherPrototype);
    }

    public static void main(String[] args) {
        new KlondikeServer().serve();
    }

    private void serve() {
        this.dispatcherPrototype.serve();
    }

}
