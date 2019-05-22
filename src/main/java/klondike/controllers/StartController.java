package klondike.controllers;

import klondike.models.Game;
import klondike.models.State;

public class StartController extends Controller {

    public StartController(Game game, State state) {
        super(game, state);
    }

    public void start() {
        this.state.next();
    }
}
