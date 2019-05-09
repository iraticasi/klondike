package klondike.menu;

import klondike.Game;
import klondike.utils.Menu;

public class PlayMenu extends Menu {

    public PlayMenu(Game game) {
        this.addCommand(new MoveFromStockToWasteCommand(game));
        this.addCommand(new MoveFromWasteToStockCommand(game));
        this.addCommand(new MoveFromWasteToFoundationCommand(game));
        this.addCommand(new MoveFromWasteToPileCommand(game));
        this.addCommand(new MoveFromFoundationToPileCommand(game));
        this.addCommand(new MoveFromPileToFoundationCommand(game));
        this.addCommand(new MoveFromPileToPileCommand(game));
        game.writeln();
    }

}
