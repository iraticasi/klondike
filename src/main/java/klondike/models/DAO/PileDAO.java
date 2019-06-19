package klondike.models.DAO;

import klondike.models.Pile;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class PileDAO extends CardStackDAO{

    private final int numberOfFaceUpCards;

    PileDAO(Pile pile) {
        super(pile);
        this.numberOfFaceUpCards= pile.getNumberOfFaceUpCards();
    }

    @Override
    void save(FileWriter fileWriter) {
        try {
            fileWriter.write(this.numberOfFaceUpCards + "\n");
            super.save(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void load(BufferedReader bufferedReader) {
        try {
            ((Pile)this.cardStack).setNumberOfFaceUpCards(Integer.parseInt(bufferedReader.readLine()));
            super.load(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
