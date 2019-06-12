package klondike.controllers;

import klondike.distributed.dispatchers.TCPIP;
import klondike.models.Session;

public abstract class AcceptorController extends Controller {

    protected TCPIP tcpip;

    AcceptorController(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }


    public abstract void accept(ControllerVisitor controllersVisitor);

}

