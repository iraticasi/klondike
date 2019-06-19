package klondike.distributed;

import klondike.distributed.dispatchers.FrameType;
import klondike.distributed.dispatchers.TCPIP;
import klondike.models.Card;
import klondike.models.Session;
import klondike.models.StateValue;
import klondike.models.Suit;

import java.util.Stack;

public class SessionProxy implements Session {

    private final TCPIP tcpip;

    public SessionProxy(TCPIP tcpip) {
        this.tcpip = tcpip;
    }

    @Override
    public Card peekStock() {
        this.tcpip.send(FrameType.PEEKSTOCK.name());
        return this.tcpip.receiveCard();
    }

    @Override
    public Card peekWaste() {
        this.tcpip.send(FrameType.PEEKWASTE.name());
        return this.tcpip.receiveCard();
    }

    @Override
    public Card peekFoundation(Suit suit) {
        this.tcpip.send(FrameType.PEEKFOUNDATION.name());
        this.tcpip.send(suit);
        return this.tcpip.receiveCard();
    }

    @Override
    public Stack<Card> getPileCards(int index) {
        this.tcpip.send(FrameType.GETPILECARDS.name());
        this.tcpip.send(index);
        int numberOfCards = this.tcpip.receiveInt();
        Stack<Card> cards = new Stack<>();
        for (int i = 0; i < numberOfCards; i++) {
            cards.add(this.tcpip.receiveCard());
        }
        return cards;
    }

    @Override
    public int getNumberOfFaceUpCardsInPile(int index) {
        this.tcpip.send(FrameType.GETNUMBEROFFACEDUPCARDSINPILE.name());
        this.tcpip.send(index);
        return this.tcpip.receiveInt();
    }

    @Override
    public boolean isGameFinished() {
        this.tcpip.send(FrameType.ISGAMEFINISHED.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public StateValue getValueState() {
        this.tcpip.send(FrameType.STATE.name());
        return StateValue.values()[this.tcpip.receiveInt()];
    }

    @Override
    public String getName() {
        this.tcpip.send(FrameType.GETTITLE.name());
        return this.tcpip.receiveLine();
    }

    @Override
    public void setName(String title) {
        this.tcpip.send(FrameType.SETTITLE.name());
        this.tcpip.send(title);
    }
}
