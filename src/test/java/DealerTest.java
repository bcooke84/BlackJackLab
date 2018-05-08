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
    public void getName() {
        assertEquals("Bob", dealer.getName());
    }

    @Test
    public void checkDeckHasCards() {
        assertEquals(52, dealer.getDeck().getNumberOfCards());

    }

    @Test
    public void getHand() {
        assertEquals(0, dealer.cardCount());
        Card card = new Card(Suit.DIAMONDS, Rank.KING);
        dealer.receiveCard(card);
        assertEquals(1, dealer.cardCount());
    }

    @Test
    public void dealerDealsCard() {
        Player player = new Player("Bob");
        dealer.deals(player);
        assertEquals(48, dealer.getDeck().getNumberOfCards());
        assertEquals(2, dealer.cardCount());
        assertEquals(2, player.cardCount());
    }

    @Test
    public void dealerTwist() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.KING);
        Card card2 = new Card(Suit.DIAMONDS, Rank.SIX);
        dealer.receiveCard(card1);
        dealer.receiveCard(card2);
        assertEquals(true, dealer.twistOrStick());
    }

    @Test
    public void dealerStick() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.KING);
        Card card2 = new Card(Suit.DIAMONDS, Rank.SEVEN);
        dealer.receiveCard(card1);
        dealer.receiveCard(card2);
        assertEquals(false, dealer.twistOrStick());
    }

}
