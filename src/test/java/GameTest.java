import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GameTest {

    Game game;
    Card card1;
    Card card2;
    Card card3;
    Card card4;
    Card card5;

    @Before
    public void before() {
        game = new Game();
        card1 = new Card(Suit.DIAMONDS, Rank.KING);
        card2 = new Card(Suit.SPADES, Rank.FIVE);
        card3 = new Card(Suit.HEARTS, Rank.ACE);
        card4 = new Card(Suit.CLUBS, Rank.ACE);
        card5 = new Card(Suit.CLUBS, Rank.KING);
    }

    @Test
    public void dealCards() {
        game.deal();
        assertEquals(2, game.getPlayerCardCount(game.getPlayer()));
        assertEquals(2, game.getPlayerCardCount(game.getDealer()));
    }

    @Test
    public void highestcardDealerWins() {
        game.getPlayer().receiveCard(card2);
        game.getPlayer().receiveCard(card3);
        game.getDealer().receiveCard(card1);
        game.getDealer().receiveCard(card4);
        assertEquals(game.getDealer(), game.compareCards());
    }

    @Test
    public void draw() {
        game.getPlayer().receiveCard(card4);
        game.getDealer().receiveCard(card3);
        assertNull(game.compareCards());
    }

    @Test
    public void canDealSingleCardToPlayer() {
        game.dealSingleCard(game.getPlayer());
        assertEquals(1, game.getPlayerCardCount(game.getPlayer()));
    }

    @Test
    public void canDealSingleCardToDealer() {
        game.dealSingleCard(game.getDealer());
        assertEquals(1, game.getPlayerCardCount(game.getDealer()));
    }

    @Test
    public void playerHasBlackJack() {
        game.getPlayer().receiveCard(card4);
        game.getPlayer().receiveCard(card1);
        assertEquals(true, game.playerHasBlackJack());
    }

    @Test
    public void isBust() {
        game.getPlayer().receiveCard(card2);
        game.getPlayer().receiveCard(card1);
        game.getPlayer().receiveCard(card5);
        assertEquals(true, game.isBust(game.getPlayer()));
    }

}
