package klondike.controllers;

import klondike.models.Session;

public class ResumeController extends AcceptorController {

    public ResumeController(Session session) {
        super(session);
    }

    public void resume(boolean newGame) {
        if (newGame) {
            this.session.resume();
        } else {
            this.session.next();
        }
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
}
