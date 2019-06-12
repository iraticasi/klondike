package klondike.controllers;

import klondike.distributed.dispatchers.FrameType;
import klondike.distributed.dispatchers.TCPIP;
import klondike.models.Session;

public class ResumeController extends AcceptorController {

    public ResumeController(Session session, TCPIP tcpip) {
        super(session, tcpip);
    }

    public void resume(boolean newGame) {
        if (this.tcpip == null) {
            if (newGame) {
                this.session.resume();
            } else {
                this.session.next();
            }
        } else {
            this.tcpip.send(FrameType.NEW_GAME.name());
            this.tcpip.send(newGame);
        }
    }


    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
}
