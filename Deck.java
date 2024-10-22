/**
 * Eli Giglietti
 * 
 * The purpose of this class is to represent a full deck of cards
 */
import java.util.ArrayList;
import java.util.Random;

public class Deck {

    /**
     * Creates the underlying deck as an ArrayList of Card objects. 
     * Calls build() as a subroutine to build the deck itself.
     */

    private ArrayList<Card> Deck;

    public Deck() {
        this.Deck = new ArrayList<Card>();
        this.build();
        this.shuffle();
    }

    /**
     * Builds the underlying deck as a standard 52 card deck. 
     * Replaces any current deck stored. 
     */
    public void build() {
        for (int i=2; i<12; i++){
            Deck.add(new Card(i));
            Deck.add(new Card(i));
            Deck.add(new Card(i));
            Deck.add(new Card(i));
        }
        for (int j = 0; j<12; j++){
            Deck.add(new Card(10));
        }
    }

    /**
     * Returns the number of cards left in the deck. 
     * @return the number of cards left in the deck
     */
    public int size() {
        return(Deck.size());
    }

    /**
     * Returns and removes the first card of the deck.
     * @return the first card of the deck
     */
    public Card deal() {
        Card holder = Deck.get(0);
        Deck.remove(0);
        return(holder);
    }

    /**
     * Shuffles the cards currently in the deck. 
     */
    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i<Deck.size(); i++){
            int rand_num = rand.nextInt(Deck.size());
            Card randCard = Deck.get(rand_num);
            Card holder = Deck.get(i);
            Deck.set(i, randCard);
            Deck.set(Deck.indexOf(randCard), holder);
        }

    }

    /**
     * Returns a string representation of the deck.
     * @return a string representation of the deck
     */
    public String toString() {
        String deckToString = "";
        for (int i = 0; i<Deck.size(); i++){
            deckToString += Deck.get(i) + " ";

        }
        return deckToString;

    }
}