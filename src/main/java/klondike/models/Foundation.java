package klondike.models;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Foundation extends CardStack {

    private Suit suit;

    public Foundation(Suit suit) {
        this.suit = suit;
    }

    public boolean isComplete() {
        return this.cards.size() == Number.values().length;
    }

    public boolean fitsIn(Card card) {
        assert card != null;
        return card.getSuit() == this.suit &&
                (card.getNumber() == Number.AS ||
                        (!this.empty() && card.isNextTo(this.peek())));
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Foundation copy() {
        Foundation copy = new Foundation(this.suit);
        copy.copyCardsFrom(this);
        return copy;
    }

    @Override
    void save(FileWriter fileWriter) {
        try {
            fileWriter.write(this.suit.toString() + "\n");
            super.save(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void load(BufferedReader bufferedReader) {
        try {
            this.suit = Suit.valueOf(bufferedReader.readLine());
            super.load(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
