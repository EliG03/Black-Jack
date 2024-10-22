/**
 * Eli Giglietti
 * 
 * The purpose of this class is to represent a game of blackjack withouth messing up my project code
 */

import java.util.ArrayList;
import java.util.scanner;

public class Blackjack {

    //initial variables made
    private int reshuffleCutoff;
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;

    //first constructor with a parameter for the shuffle cutoff
    public Blackjack(int reshuffleCutoff){
        this.reshuffleCutoff = reshuffleCutoff;
        this.deck = new Deck();
    }
    //constructor with no parameter
    public Blackjack(){
        this.reshuffleCutoff = 17;
        this.deck = new Deck();
        this.playerHand = new Hand();
        this.dealerHand = new Hand();
    }

    // gives the dealer and player new hands. If the deck is too small, will remake the deck
    public void reset(){
        if (deck.size() < this.reshuffleCutoff){
            this.deck = new Deck();
        }
        this.playerHand = new Hand();
        this.dealerHand = new Hand();
    }


    //deals out the cards, two to the player and two to the dealer
    public void deal(){
        this.playerHand.add(deck.deal());
        this.playerHand.add(deck.deal());
        this.dealerHand.add(deck.deal());
        this.dealerHand.add(deck.deal());
    }

    public boolean playerTurn(){
        //If the hand is less than 16, it gives another card
        while (playerHand.getTotalValue() < 16){
            playerHand.add(deck.deal());
        } // if the value is over 21 it returns false
        if (playerHand.getTotalValue() > 21){
            return (false);
        }
        else{
            return(true);
        }
    } 

    public boolean dealerTurn(){
        //while the hand is less than 17 it draws cards
        while (dealerHand.getTotalValue() < 17){
            dealerHand.add(deck.deal()); 
        } 
        //if the hand total is over 21, returns false 
        if (dealerHand.getTotalValue() > 21){
            return (false);
        }
        else {
            return (true);
        }
    }

    //set sets the reshuffle cutoff to whatever integer you give it
    public void setReshuffleCutoff(int cutoff){
        this.reshuffleCutoff = cutoff;
    }

    public int getReshuffleCutoff(){
        return (reshuffleCutoff);
    }

    public String toString(){
        String result = "Player Hand: "; //fromating
        //loop runs as many times as cards in the hand
        for (int i = 0; i < playerHand.size(); i++){ 
            result += playerHand.getCard(i) + ",";
        }
        //presents the total in a clean way
        result += "Total: " + playerHand.getTotalValue() + "\n";
        //repeating the process for the dealer
        result += "Dealer Hand: ";
        for (int i = 0; i < dealerHand.size(); i++){
            result += dealerHand.getCard(i) + ",";
        }
        result += "Total: "+ dealerHand.getTotalValue();
        return(result);
    }



    public static void main(String[] args){
        Blackjack game = new Blackjack(17);
        
        for(int i = 0; i<3; i++){
            game.game(true);
            System.out.println("\n");
        }
            
    }

    public int game(boolean verbose){
        reset();
        deal();
        if (verbose){
            System.out.println(toString());
        }

        playerTurn(); 
        if (playerHand.getTotalValue() > 21){

            return(-1);
        }
        
        dealerTurn();
        if (dealerHand.getTotalValue() > 21){

            return(1);
        }

        //prints the final hands
        if (verbose){
            System.out.println(toString());
        }
        
        //finds out who wins
        if (playerHand.getTotalValue() > dealerHand.getTotalValue()){

            return (1);
        }
        if (playerHand.getTotalValue() < dealerHand.getTotalValue()){

            return (-1);
        }
        else {

            return (0);
        }
        

    }

}