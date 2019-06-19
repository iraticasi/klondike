package klondike.controllers.implementation;

import klondike.controllers.StartController;
import klondike.models.Session;
import klondike.models.SessionImplementation;

public class StartControllerImplementation extends StartController {

    public StartControllerImplementation(Session session) {
        super(session);
    }

    @Override
    public void start() {
        ((SessionImplementation) this.session).next();
    }

    @Override
    public void start(String name) {
        ((SessionImplementation) this.session).load(name);
    }

    @Override
    public String[] getGamesNames() {
        return ((SessionImplementation) this.session).getGamesNames();
    }

}