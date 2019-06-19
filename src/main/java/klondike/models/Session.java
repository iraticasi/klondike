package klondike.models;

import java.util.Stack;

public interface Session {

    Card peekStock();

    Card peekWaste();

    Card peekFoundation(Suit suit);

    Stack<Card> getPileCards(int index);

    int getNumberOfFaceUpCardsInPile(int index);

    boolean isGameFinished();

    StateValue getValueState();

    String getName();

    void setName(String title);
}
