package klondike.distributed;

import klondike.controllers.ResumeController;
import klondike.distributed.dispatchers.FrameType;
import klondike.distributed.dispatchers.TCPIP;
import klondike.models.Session;

public class ResumeControllerProxy extends ResumeController {

    private TCPIP tcpip;

    public ResumeControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void resume(boolean newGame) {
        this.tcpip.send(FrameType.NEW_GAME.name());
        this.tcpip.send(newGame);
    }

}
