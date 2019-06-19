package klondike.views.console.menu;

import klondike.controllers.StartController;
import klondike.utils.Menu;

public class StartMenu extends Menu {

    public StartMenu(StartController startController) {
        this.addCommand(new NewGameCommand(startController));
        this.addCommand(new OpenGameCommand(startController));
    }
}

