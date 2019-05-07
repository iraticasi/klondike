package klondike;

import klondike.utils.IO;

import java.util.*;

public class Game {

    private static final int NUMBER_OF_PILES = 7;

    private static final String GAME_TITLE = "*********************KLONDIKE*********************";
    private static final String STOCK_TITLE = "STOCK: ";
    private static final String WASTE_TITLE = "WASTE: ";
    private static final String FOUNDATIONS_TITLE = "FOUNDATIONS: ";
    private static final String PILE_TITLE = "PILE #";

    private Stock stock;

    private Waste waste;

    private Map<Suit, Foundation> foundations;

    private List<Pile> piles;

    public Game() {
        this.clear();
    }

    public void clear() {
        this.stock = new Stock();
        this.waste = new Waste();
        this.foundations = new HashMap<>();
        for (Suit suit : Suit.values()) {
            this.foundations.put(suit, new Foundation(suit));
        }
        this.piles = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_PILES; i++) {
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

    public int moveFromStockToWaste() {
        if (this.stock.empty()) {
            return Error.EMPTY_STOCK.ordinal();
        }
        this.waste.push(this.stock.pop());
        return Error.NO_ERROR;
    }

    public int moveFromWasteToFoundation(Suit suit) {
        assert suit != null;
        if (this.waste.empty()) {
            return Error.EMPTY_WASTE.ordinal();
        }
        Card card = this.waste.peek();
        Foundation foundation = this.foundations.get(suit);
        if (!foundation.fitsIn(card)) {
            return Error.NO_FIT_FOUNDATION.ordinal();
        }
        foundation.push(this.waste.pop());
        return Error.NO_ERROR;
    }

    public int moveFromWasteToStock() {
        if (!this.stock.empty()) {
            return Error.NO_EMPTY_STOCK.ordinal();
        }
        if (this.waste.empty()) {
            return Error.EMPTY_WASTE.ordinal();
        }
        while (!this.waste.empty()) {
            this.stock.push(this.waste.pop());
        }
        return Error.NO_ERROR;
    }

    public int moveFromWasteToPile(int pileIndex) {
        assert (0 <= pileIndex) && (pileIndex <= NUMBER_OF_PILES);
        if (this.waste.empty()) {
            return Error.EMPTY_WASTE.ordinal();
        }
        Card card = this.waste.peek();
        Pile pile = this.piles.get(pileIndex);
        if (!pile.fitsIn(card)) {
            return Error.NO_FIT_PILE.ordinal();
        }
        pile.addToTop(Arrays.asList(this.waste.pop()));
        return Error.NO_ERROR;
    }

    public int moveFromFoundationToPile(Suit suit, int pileIndex) {
        assert suit != null;
        assert (0 <= pileIndex) && (pileIndex <= NUMBER_OF_PILES);
        Foundation foundation = this.foundations.get(suit);
        Pile pile = this.piles.get(pileIndex);
        if (foundation.empty()) {
            return Error.EMPTY_FOUNDATION.ordinal();
        }
        Card card = foundation.peek();
        if (!pile.fitsIn(card)) {
            return Error.NO_FIT_PILE.ordinal();
        }
        pile.addToTop(Arrays.asList(foundation.pop()));
        return Error.NO_ERROR;
    }

    public int moveFromPileToFoundation(int pileIndex, Suit suit) {
        assert (0 <= pileIndex) && (pileIndex <= NUMBER_OF_PILES);
        assert suit != null;
        Pile pile = this.piles.get(pileIndex);
        Foundation foundation = this.foundations.get(suit);
        if (pile.empty()) {
            return Error.EMPTY_PILE.ordinal();
        }
        Card card = pile.getTop(1).get(0);
        if (!foundation.fitsIn(card)) {
            return Error.NO_FIT_FOUNDATION.ordinal();
        }
        foundation.push(card);
        pile.removeTop(1);
        return Error.NO_ERROR;
    }

    public int moveFromPileToPile(int originIndex, int destinationIndex, int numberOfCards) {
        assert (0 <= originIndex) && (originIndex <= NUMBER_OF_PILES);
        assert (0 <= destinationIndex) && (destinationIndex <= NUMBER_OF_PILES);
        assert (0 <= numberOfCards);
        if (originIndex == destinationIndex) {
            return Error.SAME_PILE.ordinal();
        }
        Pile originPile = this.piles.get(originIndex);
        Pile destinationPile = this.piles.get(destinationIndex);
        if (originPile.numberOfFaceUpCards() < numberOfCards) {
            return Error.NO_ENOUGH_CARDS_PILE.ordinal();
        }
        List<Card> cards = originPile.getTop(numberOfCards);
        if (!destinationPile.fitsIn(cards.get(cards.size() - 1))) {
            return Error.NO_FIT_PILE.ordinal();
        }
        originPile.removeTop(numberOfCards);
        destinationPile.addToTop(cards);
        return Error.NO_ERROR;
    }

    public void writeln() {
        IO.writeln();
        IO.writeln(GAME_TITLE);
        IO.write(STOCK_TITLE);
        this.stock.writeln();
        IO.write(WASTE_TITLE);
        this.waste.writeln();
        IO.writeln(FOUNDATIONS_TITLE);
        for (Suit suit : Suit.values()) {
            this.foundations.get(suit).writeln();
        }
        for (int i = 0; i < NUMBER_OF_PILES; i++) {
            IO.write(PILE_TITLE + (i + 1) + ": ");
            this.piles.get(i).writeln();
        }
    }


}
