package klondike.views.menu;

import klondike.models.Game;
import klondike.utils.Menu;
import klondike.views.GameView;

public class PlayMenu extends Menu {

    public PlayMenu(Game game) {
        new GameView(game).writeln();
        this.addCommand(new MoveFromStockToWasteCommand(game));
        this.addCommand(new MoveFromWasteToStockCommand(game));
        this.addCommand(new MoveFromWasteToFoundationCommand(game));
        this.addCommand(new MoveFromWasteToPileCommand(game));
        this.addCommand(new MoveFromFoundationToPileCommand(game));
        this.addCommand(new MoveFromPileToFoundationCommand(game));
        this.addCommand(new MoveFromPileToPileCommand(game));

    }

}
