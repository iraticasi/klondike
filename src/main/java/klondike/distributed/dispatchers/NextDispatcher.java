package klondike.distributed.dispatchers;

import klondike.controllers.implementation.PlayControllerImplementation;

public class NextDispatcher extends Dispatcher {

    public NextDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        ((PlayControllerImplementation) this.acceptorController).next();
    }

}
