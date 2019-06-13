package klondike.controllers.implementation;


import klondike.controllers.ResumeController;
import klondike.models.Session;
import klondike.models.SessionImplementation;

public class ResumeControllerImplementation extends ResumeController {

    public ResumeControllerImplementation(Session session) {
        super(session);
    }

    @Override
    public void resume(boolean newGame) {
        if (newGame) {
            ((SessionImplementation) this.session).resume();
        } else {
            ((SessionImplementation) this.session).next();
        }
    }

}
