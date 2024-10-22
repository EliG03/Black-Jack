/**
 * Eli Giglietti
 * 
 * The purpose of this class is to simulate many blackjacks games and keep score
 */

import java.util.ArrayList;


public class Simulation{


    public static void main(String[] args){
        //initiating variables
        int playerWins = 0;
        int dealerWins = 0;
        int pushes = 0;
        int numGames = 1000;
        
        Blackjack game = new Blackjack(10); //making a blackjack object

    
            for (int i = 0; i<numGames; i++){ //repeats the number of games sepcificed earlier
                    game.reset();
                int result = game.game(false); //makes the game object
                if (result ==-1){ //if the dealer wins, it adds a point to the dealer
                    dealerWins++;
                }
                else if (result == 1){ //if player wins player wins, adds point to player
                    playerWins++;
                }
                else{ //if its neither, than it adds to a tie
                    pushes++;
                }
                
        }

        //makes the numbers into a percent to show the percent each person wins
        double playerPercent = (double)playerWins/1000;
        double pushesPercent = (double)pushes/1000;
        double dealerPercent = (double)dealerWins/1000;

        //prints out the results
        System.out.println("Player points: " + playerWins + " Ties: " + pushes + " Dealer pionts: " + dealerWins);
        System.out.println("Player points: " + playerPercent + " Ties: " + pushesPercent + " Dealer pionts: " + dealerPercent);
    }  

    
}

