package klondike.views;

import klondike.controllers.Controller;
import klondike.controllers.ControllerVisitor;

public abstract class View implements ControllerVisitor {

    public abstract void interact(Controller controller);

}