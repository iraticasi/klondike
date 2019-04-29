package klondike;

import klondike.utils.IO;

import java.util.*;

public class Game {

    private static final int NUMBER_OF_PILES = 7;

    private Stock stock;

    private Waste waste;

    private Map<Suit, Foundation> foundations;

    private List<Pile> piles;

    public Game() {
        this.distribute();
    }

    private void distribute() {
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

    public void moveFromStockToWaste() {
        if (!this.stock.empty()) {
            this.waste.push(this.stock.pop());
        }
    }

    public void moveFromWasteToFoundation(Suit suit) {
        assert suit != null;
        if (this.waste.empty()) {
            return;
        }
        Card card = this.waste.peek();
        Foundation foundation = this.foundations.get(suit);
        if (foundation.fitsIn(card)) {
            foundation.push(this.waste.pop());
        }

    }

    public void moveFromWasteToStock() {
        if (!this.stock.empty()) {
            return;
        }
        while (!this.waste.empty()) {
            this.stock.push(this.waste.pop());
        }
    }

    public void moveFromWasteToPile(int pileIndex) {
        assert (0 <= pileIndex) && (pileIndex <= NUMBER_OF_PILES);
        if (this.waste.empty()) {
            return;
        }
        Card card = this.waste.peek();
        Pile pile = this.piles.get(pileIndex);
        if (pile.fitsIn(card)) {
            pile.addToTop(Arrays.asList(this.waste.pop()));
        }
    }

    public void moveFromFoundationToPile(Suit suit, int pileIndex) {
        assert suit != null;
        assert (0 <= pileIndex) && (pileIndex <= NUMBER_OF_PILES);
        Foundation foundation = this.foundations.get(suit);
        Pile pile = this.piles.get(pileIndex);
        if (foundation.empty()) {
            return;
        }
        Card card = foundation.peek();
        if (pile.fitsIn(card)) {
            pile.addToTop(Arrays.asList(foundation.pop()));
        }
    }

    public void moveFromPileToFoundation(int pileIndex, Suit suit) {
        assert (0 <= pileIndex) && (pileIndex <= NUMBER_OF_PILES);
        assert suit != null;
        Pile pile = this.piles.get(pileIndex);
        Foundation foundation = this.foundations.get(suit);
        if (pile.empty()) {
            return;
        }
        Card card = pile.getTop(1).get(0);
        if (foundation.fitsIn(card)){
            foundation.push(card);
            pile.removeTop(1);
        }
    }

    public void moveFromPileToPile(int originIndex, int destinationIndex, int numberOfCards) {
        assert (0 <= originIndex) && (originIndex <= NUMBER_OF_PILES);
        assert (0 <= destinationIndex) && (destinationIndex <= NUMBER_OF_PILES);
        assert (0 <= numberOfCards);
        if (originIndex == destinationIndex) {
            return;
        }
        Pile originPile = this.piles.get(originIndex);
        Pile destinationPile = this.piles.get(destinationIndex);
        if (originPile.numberOfFaceUpCards() < numberOfCards) {
            return;
        }
        List<Card> cards = originPile.getTop(numberOfCards);
        if (destinationPile.fitsIn(cards.get(cards.size() - 1))) {
            originPile.removeTop(numberOfCards);
            destinationPile.addToTop(cards);
        }
    }

    public void writeln() {
        IO.write("STOCK: ");
        this.stock.writeln();
        IO.write("WASTE: ");
        this.waste.writeln();
        IO.writeln("FOUNDATIONS: ");
        for (Suit suit : Suit.values()) {
            this.foundations.get(suit).writeln();
        }
        for (int i = 0; i < NUMBER_OF_PILES; i++) {
            IO.write("PILE #" + (i + 1) + ": ");
            this.piles.get(i).writeln();
        }
    }


}
