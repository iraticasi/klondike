package klondike.views;

import klondike.controllers.Controller;
import klondike.controllers.ControllerVisitor;
import klondike.controllers.StartController;

public abstract class View implements ControllerVisitor {

    public abstract void interact(Controller controller);

}