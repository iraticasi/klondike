package klondike.views.console;

import klondike.models.Card;
import klondike.utils.ClosedInterval;
import klondike.utils.IO;

import java.util.Stack;

public class PileView {

    private final int index;
    private final Stack<Card> cards;

    PileView(int index, Stack<Card> cards) {
        this.index = index;
        this.cards = cards;
    }

    public static int readIndex(boolean isOrigin) {
        String pileTitle = isOrigin ? Message.ORIGIN : Message.DESTINATION;
        return IO.readInt(Message.READ_PILE_INDEX.replace(Message.PILE_TAG, pileTitle), new ClosedInterval(1, 7)) - 1;
    }

    public void writeln() {
        IO.write(Message.PILE_TITLE.replace(Message.PILE_TAG, Integer.toString(this.index)));
        if (this.cards.empty()) {
            IO.writeln(Message.EMPTY);
        } else {
            IO.writeln();
            for (Card card : this.cards) {
                IO.writetab();
                new CardView(card).writeln();
            }
        }
    }
}
