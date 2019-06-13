package klondike.models;

import klondike.utils.Memento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameMemento extends Memento {

    private Stock stock;

    private Waste waste;

    private Map<Suit, Foundation> foundations;

    private List<Pile> piles;

    public GameMemento() {
        this.foundations = new HashMap<>();
        this.piles = new ArrayList<>();
    }

    public void addFoundation(Foundation foundation) {
        this.foundations.put(foundation.getSuit(), foundation);
    }

    public void addPile(Pile pile) {
        this.piles.add(pile);
    }

    public Stock getStock() {
        return this.stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Waste getWaste() {
        return this.waste;
    }

    public void setWaste(Waste waste) {
        this.waste = waste;
    }

    public Foundation getFoundation(Suit suit) {
        return this.foundations.get(suit);
    }

    public Pile getPile(int index) {
        return this.piles.get(index);
    }
}
