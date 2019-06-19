package klondike.controllers.implementation;

import klondike.controllers.SaveController;
import klondike.models.DAO.SessionImplementationDAO;
import klondike.models.Session;
import klondike.models.SessionImplementation;

public class SaveControllerImplementation extends SaveController {

    private final SessionImplementationDAO sessionImplementationDAO;

    SaveControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
        super(session);
        this.sessionImplementationDAO = sessionImplementationDAO;
    }

    @Override
    public void save(String name) {
        this.sessionImplementationDAO.save(name);
    }

    @Override
    public void save() {
        this.sessionImplementationDAO.save();
    }

    @Override
    public void next() {
        ((SessionImplementation) this.session).next();
    }

    @Override
    public boolean hasName() {
        return ((SessionImplementation) this.session).hasName();
    }

    @Override
    public boolean exists(String name) {
        return this.sessionImplementationDAO.exists(name);
    }

}
