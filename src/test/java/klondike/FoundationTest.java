package klondike;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoundationTest {

    private Card asOfPikes= new Card(Suit.PIKES, Number.AS);
    private Card asOfHearts = new Card(Suit.HEARTS, Number.AS);
    private Card twoOfPikes = new Card(Suit.PIKES, Number.TWO);
    private Card twoOfHearts = new Card(Suit.HEARTS, Number.TWO);

    @Test
    void fitsIn() {
        Foundation pikesFoundation = new Foundation(Suit.PIKES);
        assertFalse(pikesFoundation.fitsIn(asOfHearts));
        assertFalse(pikesFoundation.fitsIn(twoOfPikes));
        assertTrue(pikesFoundation.fitsIn(asOfPikes));
        pikesFoundation.push(asOfPikes);
        assertFalse(pikesFoundation.fitsIn(twoOfHearts));
        assertTrue(pikesFoundation.fitsIn(twoOfPikes));

    }
}