import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    Dealer dealer;

    @Before
    public void before() {
        dealer = new Dealer("Bob");
    }

    @Test
    public void getName(){
        assertEquals("Bob", dealer.getName());
    }

    @Test
    public void checkDeckHasCards(){
        assertEquals(52, dealer.getDeck().getNumberOfCards());

    }

    @Test
    public void getHand(){
        assertEquals(0, dealer.cardCount());
        Card card = new Card(Suit.DIAMONDS, Rank.KING);
        dealer.receiveCard(card);
        assertEquals(1, dealer.cardCount());

    }

    @Test
    public void dealerDealsCard(){
        Player player = new Player("Bob");
        dealer.deals(player);
        assertEquals(48, dealer.getDeck().getNumberOfCards());
        assertEquals(2, dealer.cardCount());
        assertEquals(2, player.cardCount());
    }

    @Test
    public void dealerCanTwist() {

        assertEquals(3, dealer.cardCount());
    }

}
