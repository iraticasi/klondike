package klondike.models.DAO;

import klondike.models.Card;
import klondike.models.Number;
import klondike.models.Suit;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class CardDAO implements DAO{

    private final Card card;

    public CardDAO(Card card) {
        this.card = card;
    }

    public void save(FileWriter fileWriter) {
        try {
            fileWriter.write(this.card.getSuit().toString() + "\n");
            fileWriter.write(this.card.getNumber().toString() + "\n");
            fileWriter.write(this.card.isFacedUp() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(BufferedReader bufferedReader) {
        try {
            this.card.setSuit(Suit.valueOf(bufferedReader.readLine()));
            this.card.setNumber(Number.valueOf(bufferedReader.readLine()));
            boolean facedUp = Boolean.parseBoolean(bufferedReader.readLine());
            if (facedUp != this.card.isFacedUp()){
                this.card.flip();
            }
        } catch (IOException e) {
        }
    }

    public Card getCard() {
        return this.card;
    }
}
