package klondike.controllers;

import klondike.distributed.dispatchers.FrameType;
import klondike.distributed.dispatchers.TCPIP;
import klondike.models.Session;

public class StartController extends AcceptorController {

    public StartController(Session session, TCPIP tcpip) {
        super(session, tcpip);
    }

    public void start() {
        if (this.tcpip == null) {
            this.session.next();
        } else {
            this.tcpip.send(FrameType.START.name());
        }
    }


    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
}
