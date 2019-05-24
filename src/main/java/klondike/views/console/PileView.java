package klondike.views.console;

import klondike.controllers.Logic;
import klondike.models.Card;
import klondike.utils.ClosedInterval;
import klondike.utils.IO;

import java.util.Stack;

public class PileView {

    private final Logic logic;

    private final int index;

    public PileView(Logic logic, int index) {
        this.logic = logic;
        this.index = index;
    }

    public void writeln() {
        Stack<Card> cards = this.logic.getPileCards(index);
        int numberOfFaceUpCards = this.logic.getNumberOfFaceUpCardsInPile(index);
        int numberOfFaceDownCards = cards.size() - numberOfFaceUpCards;
        IO.writetab();
        IO.write(this.index + ": ");
        if (cards.empty()) {
            IO.write(Message.EMPTY);
        } else {
            if (numberOfFaceDownCards > 0) {
                new CardView(cards.get(0)).write();
                IO.write(" (x" + numberOfFaceDownCards + "), ");
            }
            for (int i = 0; i < numberOfFaceUpCards; i++) {
                Card card = cards.get(numberOfFaceDownCards + i);
                new CardView(card).write();
                if (i < numberOfFaceUpCards - 1) {
                    IO.write(", ");
                }
            }
        }
        IO.writeln();
    }
}
