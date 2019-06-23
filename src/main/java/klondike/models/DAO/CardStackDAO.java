package klondike.models.DAO;

import klondike.models.Card;
import klondike.models.CardStack;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class CardStackDAO implements DAO{

    protected final CardStack cardStack;

    CardStackDAO(CardStack cardStack){
        this.cardStack = cardStack;
    }

    public void save(FileWriter fileWriter) {
        try {
            fileWriter.write(this.cardStack.getCards().size() + "\n");
            for (int i = 0; i < this.cardStack.getCards().size(); i++) {
                new CardDAO(this.cardStack.getCards().get(i)).save(fileWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(BufferedReader bufferedReader) {
        try {
            this.cardStack.getCards().removeAllElements();
            int numberOfCards = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < numberOfCards; i++) {
                CardDAO cardDAO = new CardDAO(new Card());
                cardDAO.load(bufferedReader);
                this.cardStack.getCards().add(cardDAO.getCard());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
