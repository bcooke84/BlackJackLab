import java.util.ArrayList;

public class Game {

    private Dealer dealer;
    private Player player;

    public Game() {
        this.dealer = new Dealer("Dealer");
        this.player = new Player("Bob");
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Player getPlayer() {
        return player;
    }

    public void deal() {
        dealer.deals(player);
    }

    public Player compareCards() {
        if (player.handValue() > dealer.handValue()) {
            return player;
        } else if (dealer.handValue() > player.handValue()) {
            return dealer;
        } else return null;
    }

    public boolean isBust() {
        return player.handValue() > 21;
    }

    public boolean isBlackJack() {
        return player.handValue() == 21;
    }


}

