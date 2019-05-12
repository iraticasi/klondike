package klondike;

import klondike.utils.IO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stock extends CardStack {

    public Stock() {
        super();
        for (Suit suit : Suit.values()) {
            for (Number number : Number.values()) {
                this.cards.add(new Card(suit, number));
            }
        }
        Collections.shuffle(this.cards);
    }

    public List<Card> takeTop(int quantity) {
        assert 0 < quantity && quantity <= this.cards.size();
        List<Card> cardsToReturn = new ArrayList<>(this.cards.subList(0, quantity));
        this.cards.removeAll(cardsToReturn);
        return cardsToReturn;
    }

    public void writeln() {
        IO.write(Message.STOCK_TITLE);
        if (this.empty()) {
            IO.writeln(Message.EMPTY);
        }else{
            this.peek().writeln();
        }

    }

}
