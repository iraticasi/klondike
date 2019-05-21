package klondike.views.console;

import klondike.controllers.Logic;
import klondike.models.Suit;
import klondike.utils.IO;

public class FoundationView extends CardStackView {

    private final Suit suit;

    public FoundationView(Logic logic, Suit suit) {
        super(logic, Message.FOUNDATION_TITLE.replace(Message.FOUNDATION_TAG, suit.toString().toLowerCase()));
        this.suit = suit;
    }


    public void writeln() {
        IO.writetab();
        super.writeln(this.logic.peekFoundation(suit));
    }
}
