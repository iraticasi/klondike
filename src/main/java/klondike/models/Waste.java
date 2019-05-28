package klondike.models;

public class Waste extends CardStack {

    public Waste copy() {
        Waste copy = new Waste();
        copy.copyCardsFrom(this);
        return copy;
    }
}
