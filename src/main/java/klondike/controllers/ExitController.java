package klondike.controllers;

import klondike.models.Session;
import klondike.models.SessionImplementation;

public class ExitController extends Controller {

    public ExitController(Session session) {
        super(session);
    }

    public void next() {
        ((SessionImplementation) this.session).next();
    }

}