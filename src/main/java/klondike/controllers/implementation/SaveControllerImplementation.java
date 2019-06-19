package klondike.controllers.implementation;

import klondike.controllers.SaveController;
import klondike.models.Session;
import klondike.models.SessionImplementation;

public class SaveControllerImplementation extends SaveController {

    SaveControllerImplementation(Session session) {
        super(session);
    }

    @Override
    public void save(String name) {
        ((SessionImplementation) this.session).save(name);
    }

    @Override
    public void save() {
        ((SessionImplementation) this.session).save();
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
        return ((SessionImplementation) this.session).exists(name);
    }

}
