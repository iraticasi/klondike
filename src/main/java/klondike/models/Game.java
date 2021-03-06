package klondike.models;

import klondike.utils.Memento;
import klondike.utils.Originator;

import java.util.*;

public class Game implements Originator {

    public static final int NUMBER_OF_PILES = 7;

    private Stock stock;

    private Waste waste;

    private Map<Suit, Foundation> foundations;

    private List<Pile> piles;

    public Game() {
        this.clear();
    }

    public void clear() {
        this.stock = new Stock();
        this.stock.generateCards();
        this.waste = new Waste();
        this.foundations = new HashMap<>();
        for (Suit suit : Suit.values()) {
            this.foundations.put(suit, new Foundation(suit));
        }
        this.piles = new ArrayList<>();
        for (int i = 0; i < Game.NUMBER_OF_PILES; i++) {
            this.piles.add(new Pile(this.stock.takeTop(i + 1)));
        }
    }

    public boolean isFinished() {
        for (Suit suit : Suit.values()) {
            if (!this.foundations.get(suit).isComplete()) {
                return false;
            }
        }
        return true;
    }

    public Error moveFromStockToWaste() {
        if (this.stock.empty()) {
            return Error.EMPTY_STOCK;
        }
        this.waste.push(this.stock.pop().flip());
        return null;
    }

    public Error moveFromWasteToFoundation(Suit suit) {
        assert suit != null;
        if (this.waste.empty()) {
            return Error.EMPTY_WASTE;
        }
        Card card = this.waste.peek();
        Foundation foundation = this.foundations.get(suit);
        if (!foundation.fitsIn(card)) {
            return Error.NO_FIT_FOUNDATION;
        }
        foundation.push(this.waste.pop());
        return null;
    }

    public Error moveFromWasteToStock() {
        if (!this.stock.empty()) {
            return Error.NO_EMPTY_STOCK;
        }
        if (this.waste.empty()) {
            return Error.EMPTY_WASTE;
        }
        while (!this.waste.empty()) {
            this.stock.push(this.waste.pop().flip());
        }
        return null;
    }

    public Error moveFromWasteToPile(int pileIndex) {
        assert (0 <= pileIndex) && (pileIndex <= Game.NUMBER_OF_PILES);
        if (this.waste.empty()) {
            return Error.EMPTY_WASTE;
        }
        Card card = this.waste.peek();
        Pile pile = this.piles.get(pileIndex);
        if (!pile.fitsIn(card)) {
            return Error.NO_FIT_PILE;
        }
        pile.addToTop(Arrays.asList(this.waste.pop()));
        return null;
    }

    public Error moveFromFoundationToPile(Suit suit, int pileIndex) {
        assert suit != null;
        assert (0 <= pileIndex) && (pileIndex <= Game.NUMBER_OF_PILES);
        Foundation foundation = this.foundations.get(suit);
        Pile pile = this.piles.get(pileIndex);
        if (foundation.empty()) {
            return Error.EMPTY_FOUNDATION;
        }
        Card card = foundation.peek();
        if (!pile.fitsIn(card)) {
            return Error.NO_FIT_PILE;
        }
        pile.addToTop(Arrays.asList(foundation.pop()));
        return null;
    }

    public Error moveFromPileToFoundation(int pileIndex, Suit suit) {
        assert (0 <= pileIndex) && (pileIndex <= Game.NUMBER_OF_PILES);
        assert suit != null;
        Pile pile = this.piles.get(pileIndex);
        Foundation foundation = this.foundations.get(suit);
        if (pile.empty()) {
            return Error.EMPTY_PILE;
        }
        Card card = pile.getTop(1).get(0);
        if (!foundation.fitsIn(card)) {
            return Error.NO_FIT_FOUNDATION;
        }
        foundation.push(card);
        pile.removeTop(1);
        return null;
    }

    public Error moveFromPileToPile(int originIndex, int destinationIndex, int numberOfCards) {
        assert (0 <= originIndex) && (originIndex <= Game.NUMBER_OF_PILES);
        assert (0 <= destinationIndex) && (destinationIndex <= Game.NUMBER_OF_PILES);
        assert (0 <= numberOfCards);
        if (originIndex == destinationIndex) {
            return Error.SAME_PILE;
        }
        Pile originPile = this.piles.get(originIndex);
        Pile destinationPile = this.piles.get(destinationIndex);
        if (originPile.getNumberOfFaceUpCards() < numberOfCards) {
            return Error.NO_ENOUGH_CARDS_PILE;
        }
        List<Card> cards = originPile.getTop(numberOfCards);
        if (!destinationPile.fitsIn(cards.get(cards.size() - 1))) {
            return Error.NO_FIT_PILE;
        }
        originPile.removeTop(numberOfCards);
        destinationPile.addToTop(cards);
        return null;
    }

    public Card peekStock() {
        return this.peekIfNotEmpty(this.stock);
    }

    public Card peekWaste() {
        return this.peekIfNotEmpty(this.waste);
    }

    public Card peekFoundation(Suit suit) {
        return this.peekIfNotEmpty(this.foundations.get(suit));
    }

    private Card peekIfNotEmpty(CardStack cardStack) {
        if (cardStack.empty()) {
            return null;
        } else {
            return cardStack.peek();
        }
    }

    public Stack<Card> getPileCards(int index) {
        return this.piles.get(index).getCards();
    }

    public int getNumberOfFaceUpCardsInPile(int index) {
        return this.piles.get(index).getNumberOfFaceUpCards();
    }

    @Override
    public GameMemento createMemento() {
        GameMemento gameMemento = new GameMemento();
        gameMemento.setStock(this.stock.copy());
        gameMemento.setWaste(this.waste.copy());
        for (Suit suit : Suit.values()) {
            gameMemento.addFoundation(this.foundations.get(suit).copy());
        }
        for (int i = 0; i < Game.NUMBER_OF_PILES; i++) {
            gameMemento.addPile(this.piles.get(i).copy());
        }
        return gameMemento;
    }

    @Override
    public void restore(Memento memento) {
        GameMemento gameMemento = (GameMemento) memento;
        this.stock = gameMemento.getStock().copy();
        this.waste = gameMemento.getWaste().copy();
        this.foundations = new HashMap<>();
        for (Suit suit : Suit.values()) {
            this.foundations.put(suit, gameMemento.getFoundation(suit).copy());
        }
        this.piles = new ArrayList<>();
        for (int i = 0; i < Game.NUMBER_OF_PILES; i++) {
            this.piles.add(gameMemento.getPile(i).copy());
        }
    }

    public Stock getStock() {
        return this.stock;
    }

    public Waste getWaste() {
        return this.waste;
    }

    public Foundation getFoundation(Suit suit) {
        return this.foundations.get(suit);
    }

    public Pile getPile(int pileIndex) {
        return this.piles.get(pileIndex);
    }


}
