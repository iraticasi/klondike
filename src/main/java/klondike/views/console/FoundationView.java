package klondike.views.console;

import klondike.controllers.Controller;
import klondike.models.Suit;
import klondike.utils.IO;

public class FoundationView extends CardStackView {


    private final Suit suit;

    public FoundationView(Controller controller, Suit suit) {
        super(controller, Message.FOUNDATION_TITLE.replace(Message.FOUNDATION_TAG, suit.toString().toLowerCase()));
        this.suit = suit;
    }


    public void writeln() {
        IO.writetab();
        super.writeln(this.controller.peekFoundation(suit));
    }
}
