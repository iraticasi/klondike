package klondike.views.console;

import klondike.models.Card;
import klondike.models.Pile;
import klondike.utils.ClosedInterval;
import klondike.utils.IO;

public class PileView {

    private final Pile pile;

    PileView(Pile pile) {
        this.pile = pile;
    }

    public static int readIndex(boolean isOrigin) {
        String pileTitle = isOrigin ? Message.ORIGIN : Message.DESTINATION;
        return IO.readInt(Message.READ_PILE_INDEX.replace(Message.PILE_TAG, pileTitle), new ClosedInterval(1, 7)) - 1;
    }

    public void writeln() {
        IO.write(Message.PILE_TITLE.replace(Message.PILE_TAG, Integer.toString(this.pile.getNumber())));
        if (this.pile.empty()) {
            IO.writeln(Message.EMPTY);
        } else {
            IO.writeln();
            for (Card card : this.pile.getCards()) {
                IO.writetab();
                new CardView(card).writeln();
            }
        }
    }
}
