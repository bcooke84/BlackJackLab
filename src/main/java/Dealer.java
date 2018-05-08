import java.util.ArrayList;

public class Dealer extends Player {
    protected Deck deck;
    private ArrayList<Card> hand;

    public Dealer(String name) {
        super(name);
        this.deck = new Deck();
        this.hand = new ArrayList<>();
    }

    public Deck getDeck() {
        return deck;
    }

    public void receiveCard(Card card) {
        this.hand.add(card);
    }

    public int cardCount() {
        return this.hand.size();
    }

    public int handValue() {
        int cardCounter = 0;
        for (Card card : this.hand) {
            cardCounter += card.getRank().getValue();
        }
        return cardCounter;
    }

    public void deals(Player player){
        player.receiveCard(deck.removeCard());
        this.receiveCard(deck.removeCard());
        player.receiveCard(deck.removeCard());
        this.receiveCard(deck.removeCard());
    }

    public void dealCardToPlayer(Player player) {
        player.receiveCard(deck.removeCard());
    }

    public void dealCardToDealer() {
        this.receiveCard(deck.removeCard());
    }

    public boolean twistOrStick() {
        return this.handValue() < 17;
    }

}
