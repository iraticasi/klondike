package klondike.controllers;

import klondike.models.Session;

public abstract class AcceptorController extends Controller {

    AcceptorController(Session session) {
        super(session);
    }

    public abstract void accept(ControllerVisitor controllersVisitor);

}

