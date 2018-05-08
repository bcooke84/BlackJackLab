import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player1;
    Card card;
    Card card2;

    @Before
    public void before() {
        player1 = new Player("Jim");
        card = new Card(Suit.CLUBS, Rank.EIGHT);
        card2 = new Card(Suit.HEARTS, Rank.FOUR);
    }

    @Test
    public void playerHasName() {
        assertEquals("Jim", player1.getName());
    }

    @Test
    public void playerHasCards() {
        player1.receiveCard(card);
        assertEquals(1, player1.cardCount());
    }

    @Test
    public void valueOfHand() {
        player1.receiveCard(card);
        player1.receiveCard(card2);
        assertEquals(12, player1.handValue());
    }

}
