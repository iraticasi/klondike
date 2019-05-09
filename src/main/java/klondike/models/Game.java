package klondike.models;

import java.util.*;

public class Game {

    public static final int NUMBER_OF_PILES = 7;

    private Stock stock;

    private CardStack waste;

    private Map<Suit, Foundation> foundations;

    private List<Pile> piles;

    public Game() {
        this.clear();
    }

    public void clear() {
        this.stock = new Stock();
        this.waste = new CardStack();
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
        if (originPile.numberOfFaceUpCards() < numberOfCards) {
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


    public Stock getStock() {
        return this.stock;
    }

    public CardStack getWaste() {
        return this.waste;
    }

    public Map<Suit, Foundation> getFoundations() {
        return foundations;
    }

    public List<Pile> getPiles() {
        return piles;
    }
}
