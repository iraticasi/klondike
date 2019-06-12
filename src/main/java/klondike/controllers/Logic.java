package klondike.controllers;

import klondike.models.Session;
import klondike.models.StateValue;
import klondike.distributed.dispatchers.TCPIP;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    private Session session;

    private Map<StateValue, AcceptorController> controllers;

    protected StartController startController;

    protected PlayController playController;

    protected ResumeController resumeController;

    private TCPIP tcpip;

    public Logic (Boolean isStandalone) {
        if (isStandalone) {
            this.tcpip = null;
        } else {
            this.tcpip = TCPIP.createClientSocket();
        }
        this.session = new Session(this.tcpip);
        this.controllers = new HashMap<>();
        this.startController = new StartController(this.session, this.tcpip);
        this.controllers.put(StateValue.INITIAL, this.startController);
        this.playController = new PlayController(this.session, this.tcpip);
        this.controllers.put(StateValue.IN_GAME, this.playController);
        this.resumeController= new ResumeController(this.session, this.tcpip);
        this.controllers.put(StateValue.FINAL,resumeController);
        this.controllers.put(StateValue.EXIT, null);
    }

    public AcceptorController getController() {
        return this.controllers.get(this.session.getValueState());
    }

    public void close() {
        this.tcpip.close();
    }
}
