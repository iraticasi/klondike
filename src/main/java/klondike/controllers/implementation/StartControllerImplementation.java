package klondike.controllers.implementation;

import klondike.controllers.StartController;
import klondike.models.DAO.SessionImplementationDAO;
import klondike.models.Session;
import klondike.models.SessionImplementation;

public class StartControllerImplementation extends StartController {

    private final SessionImplementationDAO sessionImplementationDAO;

    public StartControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
        super(session);
        this.sessionImplementationDAO = sessionImplementationDAO;
    }

    @Override
    public void start() {
        ((SessionImplementation) this.session).next();
    }

    @Override
    public void start(String name) {
        this.sessionImplementationDAO.load(name);
    }

    @Override
    public String[] getGamesNames() {
        return this.sessionImplementationDAO.getGamesNames();
    }

}