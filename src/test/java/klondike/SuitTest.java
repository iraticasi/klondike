package klondike;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuitTest {

    @Test
    void getColor(){
        assertEquals(Suit.HEARTS.getColor(),Color.RED);
        assertEquals(Suit.DIAMONDS.getColor(),Color.RED);
        assertEquals(Suit.CLOVERS.getColor(),Color.BLACK);
        assertEquals(Suit.PIKES.getColor(),Color.BLACK);
    }
}