package klondike.controllers;

import klondike.models.Game;
import klondike.models.State;
import klondike.models.StateValue;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    private final State state;

    private Game game;

    private Map<StateValue, Controller> controllers;

    public Logic() {
        this.state = new State();
        this.game = new Game();
        this.controllers = new HashMap<>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
        this.controllers.put(StateValue.IN_GAME, new MoveController(this.game, this.state));
        this.controllers.put(StateValue.FINAL, new ResumeController(this.game, this.state));
        this.controllers.put(StateValue.EXIT, null);
    }

    public Controller getController() {
        return this.controllers.get(this.state.getValueState());
    }
}
