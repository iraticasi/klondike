package klondike.models;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class CardStack {

    protected Stack<Card> cards;

    public CardStack() {
        this.cards = new Stack<>();
    }

    public boolean empty() {
        return this.cards.empty();
    }

    public Card peek() {
        return this.cards.peek();
    }

    public Card pop() {
        return this.cards.pop();
    }

    public void push(Card card) {
        this.cards.push(card);
    }

    protected void copyCardsFrom(CardStack cardStack) {
        List<Card> copiedCards = new ArrayList<>();
        for (Card card : cardStack.cards) {
            copiedCards.add(card.copy());
        }
        this.cards.addAll(copiedCards);
    }

    void save(FileWriter fileWriter) {
        try {
            fileWriter.write(this.cards.size() + "\n");
            for (int i = 0; i < this.cards.size(); i++) {
                this.cards.get(i).save(fileWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void load(BufferedReader bufferedReader) {
        try {
            this.cards.removeAllElements();
            int numberOfCards = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < numberOfCards; i++) {
                Card card = new Card();
                card.load(bufferedReader);
                this.cards.add(card);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
