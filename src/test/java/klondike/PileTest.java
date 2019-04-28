package klondike;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PileTest {

    private Card jackOfHearts = new Card(Suit.HEARTS, Number.JACK);
    private Card tenOfPikes = new Card(Suit.PIKES, Number.TEN);
    private Card tenOfHearts = new Card(Suit.HEARTS, Number.TEN);
    private Card threeOfPikes = new Card(Suit.PIKES, Number.THREE);
    private Card king = new Card(Suit.PIKES, Number.KING);

    @Test
    void fitsIn() {
        Pile pile = new Pile(Arrays.asList(jackOfHearts));
        assertTrue(pile.fitsIn(tenOfPikes));
        assertFalse(pile.fitsIn(tenOfHearts));
        assertFalse(pile.fitsIn(threeOfPikes));

        Pile emptyPile = new Pile(new ArrayList<Card>());
        assertTrue(emptyPile.fitsIn(king));
        assertFalse(emptyPile.fitsIn(tenOfHearts));
    }
}