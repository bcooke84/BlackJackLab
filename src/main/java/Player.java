import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
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

}
