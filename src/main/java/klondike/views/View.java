package klondike.views;

import klondike.controllers.AcceptorController;
import klondike.controllers.ControllerVisitor;

public abstract class View implements ControllerVisitor {

    public abstract void interact(AcceptorController acceptorController);

}