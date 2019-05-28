package klondike.views.console.menu;

import klondike.controllers.PlayController;
import klondike.utils.Menu;

public class PlayMenu extends Menu {

    public PlayMenu(PlayController playController) {
        this.addCommand(new MoveFromStockToWasteCommand(playController));
        this.addCommand(new MoveFromWasteToStockCommand(playController));
        this.addCommand(new MoveFromWasteToFoundationCommand(playController));
        this.addCommand(new MoveFromWasteToPileCommand(playController));
        this.addCommand(new MoveFromFoundationToPileCommand(playController));
        this.addCommand(new MoveFromPileToFoundationCommand(playController));
        this.addCommand(new MoveFromPileToPileCommand(playController));
        this.addCommand(new UndoCommand(playController));
        this.addCommand(new RedoCommand(playController));
    }

}
