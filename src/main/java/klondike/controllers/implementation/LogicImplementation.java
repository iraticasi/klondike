package klondike.controllers.implementation;

import klondike.controllers.Logic;
import klondike.models.DAO.SessionImplementationDAO;
import klondike.models.SessionImplementation;
import klondike.models.StateValue;

public class LogicImplementation extends Logic {

    protected StartControllerImplementation startControllerImplementation;

    protected PlayControllerImplementation playControllerImplementation;

    protected SaveControllerImplementation saveControllerImplementation;

    protected ResumeControllerImplementation resumeControllerImplementation;

    public LogicImplementation() {
        this.session = new SessionImplementation();
        SessionImplementationDAO sessionImplementationDAO = new SessionImplementationDAO((SessionImplementation) this.session);
        this.startControllerImplementation = new StartControllerImplementation(this.session, sessionImplementationDAO);
        this.playControllerImplementation = new PlayControllerImplementation(this.session);
        this.saveControllerImplementation = new SaveControllerImplementation(this.session, sessionImplementationDAO);
        this.resumeControllerImplementation = new ResumeControllerImplementation(this.session);
        this.acceptorControllers.put(StateValue.INITIAL, this.startControllerImplementation);
        this.acceptorControllers.put(StateValue.IN_GAME, this.playControllerImplementation);
        this.acceptorControllers.put(StateValue.SAVING, this.saveControllerImplementation);
        this.acceptorControllers.put(StateValue.FINAL, this.resumeControllerImplementation);
        this.acceptorControllers.put(StateValue.EXIT, null);
    }
}
