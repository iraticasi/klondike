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

    public static int readIndex(String title) {
        return IO.readInt(Message.READ_PILE_INDEX.replace(Message.PILE_TAG, title), new ClosedInterval(1, 7)) - 1;
    }

    public void writeln() {
        IO.writetab();
        IO.write(this.pile.getNumber()+ ": ");
        if (this.pile.getCards().empty()) {
            IO.write(Message.EMPTY);
        } else {
            if (this.pile.numberOfFaceDownCards() > 0) {
                new CardView(this.pile.getCards().get(0)).write();
                IO.write(" (x" + this.pile.numberOfFaceDownCards() + "), ");
            }
            for (int i = 0; i < this.pile.numberOfFaceUpCards(); i++) {
                Card card = this.pile.getCards().get(this.pile.numberOfFaceDownCards() + i);
                new CardView(card).write();
                if (i < this.pile.numberOfFaceUpCards() - 1) {
                    IO.write(", ");
                }
            }
        }
        IO.writeln();
    }
}
