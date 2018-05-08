import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        populateDeck();
        shuffleDeck();
    }

//    call methods in constructor but do not write methods in constructor.

    private void populateDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                this.cards.add(card);
            }
        }
    }

        public int getNumberOfCards() {
            return this.cards.size();
        }

        private void shuffleDeck() {
        Collections.shuffle(this.cards);
        }

//        Collections is an inbuilt Java thing, shuffle is an inbuilt method for it.

        public Card removeCard() {
        return this.cards.remove(0);
    }

    }

//    .values brings back every enum name, built in enum method.
//    use nested loops when you want to bring together 2 collections and have 1 of each thing e.g. Spades + ranks then Hearts + ranks until deck is populated.

