package klondike.views.console;

import klondike.controllers.Controller;
import klondike.models.Card;
import klondike.models.Suit;
import klondike.utils.IO;

public class FoundationView extends CardStackView{


    private final Controller controller;
    private final Suit suit;

    public FoundationView(Controller controller, Suit suit) {
        super(Message.FOUNDATION_TITLE.replace(Message.FOUNDATION_TAG, suit.toString().toLowerCase()));
        this.controller = controller;
        this.suit = suit;
    }


    public void writeln() {
        IO.writetab();
        super.writeln(this.controller.peekFoundation(suit));
    }
}
