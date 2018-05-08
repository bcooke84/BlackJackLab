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
    Dealer dealer;
    Player player;

    @Before
    public void before(){
        game = new Game();
        card1 = new Card(Suit.DIAMONDS, Rank.KING);
        card2 = new Card(Suit.SPADES, Rank.FIVE);
        card3 = new Card(Suit.HEARTS, Rank.ACE);
        card4 = new Card(Suit.CLUBS, Rank.ACE);
    }

    @Test
    public void dealCards(){
        game.deal();
        assertEquals(2, game.getPlayer().cardCount());
        assertEquals(2, game.getDealer().cardCount());
    }

    @Test
    public void highestCardPlayer1Wins(){
        game.getPlayer().receiveCard(card1);
        game.getDealer().receiveCard(card2);
        assertEquals(game.getPlayer(), game.compareCards());
    }

    @Test
    public void highestcardPlayer2Wins(){
        game.getPlayer().receiveCard(card2);
        game.getDealer().receiveCard(card1);
        assertEquals(game.getDealer(), game.compareCards());
    }

    @Test
    public void highestcardPlayer2Wins2cards(){
        game.getPlayer().receiveCard(card2);
        game.getPlayer().receiveCard(card3);
        game.getDealer().receiveCard(card1);
        game.getDealer().receiveCard(card4);
        assertEquals(game.getDealer(), game.compareCards());
    }

    @Test
    public void draw(){
        game.getPlayer().receiveCard(card4);
        game.getDealer().receiveCard(card3);
        assertNull(game.compareCards());
    }
}
