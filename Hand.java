/**
 * Eli Giglietti
 * 
 * The purpose of this class is to respreset hand of cards
 */

import java.util.ArrayList;

public class Hand {

    /**
     * Creates an empty hand as an ArrayList of Cards.  
     */

    private ArrayList<Card> myHand;
    public Hand(){
        myHand = new ArrayList<Card>();
    }

    /**
     * Removes any cards currently in the hand. 
     */
    public void reset(){
        myHand = new ArrayList<Card>();
    }

    /**
     * Adds the specified card to the hand.
     * @param card the card to be added to the hand
     */
    public void add(Card card){
        myHand.add(card);
    }

    /**
     * Returns the number of cards in the hand.
     * @return the number of cards in the hand
     */
    public int size(){
        return(myHand.size());
    }

    /**
     * Returns the card in the hand specified by the given index. 
     * @param index the index of the card in the hand.
     * @return the card in the hand at the specified index.
     */
    public Card getCard(int index){
        return(myHand.get(index));
    }

    /**
     * Returns the summed value over all cards in the hand.
     * @return the summed value over all cards in the hand
     */
    public int getTotalValue(){
        int sum = 0;
        for (int i = 0; i<myHand.size(); i++){
            sum += myHand.get(i).getValue();
        }
        return(sum);
    }

    /**
     * Returns a string representation of the hand.
     * @return a string representation of the hand
     */
    public String toString(){
        String result = "[";
        for (int i = 0; i<myHand.size(); i++){
            result += myHand.get(i) + ", ";
        }
        int total = this.getTotalValue();
        result += "] : ";
        result += total;
        return(result);
    }
}