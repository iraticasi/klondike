package klondike.views.console;

import klondike.controllers.Controller;
import klondike.models.Card;
import klondike.utils.IO;

import java.util.Stack;

public class PileView {

    private final Controller controller;

    private final int index;

    public PileView(Controller controller, int index) {
        this.controller = controller;
        this.index = index;
    }

    public void writeln() {
        Stack<Card> cards = this.controller.getPileCards(index);
        int numberOfFaceUpCards = this.controller.getNumberOfFaceUpCardsInPile(index);
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
