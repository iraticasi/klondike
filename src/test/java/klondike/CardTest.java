package klondike;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void isNextTo() {
        Card queen = new Card(Suit.HEARTS, Number.QUEEN);
        Card jack = new Card(Suit.HEARTS, Number.JACK);
        Card three = new Card(Suit.HEARTS, Number.THREE);
        assertTrue(queen.isNextTo(jack));
        assertFalse(jack.isNextTo(queen));
        assertFalse(queen.isNextTo(three));
    }
}