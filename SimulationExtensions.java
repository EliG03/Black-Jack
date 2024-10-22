import java.util.ArrayList;
import java.util.Scanner;

/**
 * Eli Giglietti
 * 
 * the purpose of this class is to Simulate many blackjacks games and keep score with extensions..
 * so my code for the project isn't messed up
 */

public class SimulationExtensions{


    public static void main(String[] args){
        //making a scanner obj
        Scanner scan = new Scanner(System.in);

        System.out.println("How many sets do you want?");
        int set = scan.nextInt(); //lets the scanner input an integer

        System.out.println("How many games per set?");
        int numGames = scan.nextInt();

        scan.close();

    
        //Initiating my variables
        int playerWins = 0;
        int dealerWins = 0;
        int pushes = 0;
        ArrayList<Double> playerWinPercent = new ArrayList<Double>();
        ArrayList<Double> dealerWinPercent = new ArrayList<Double>();
        ArrayList<Double> tiePercent = new ArrayList<Double>();
        
        Blackjack game = new Blackjack(10); 
        for (int g = 0; g<set; g++){

            numGames += 100;
        
        for (int y = 0; y<10; y++){
        playerWins = 0;    
        dealerWins = 0;
        pushes = 0;
                for (int i = 0; i<numGames; i++){
                    game.reset();
                int result = game.game(false);
                if (result ==-1){
                    dealerWins++;
                }
                else if (result == 1){
                    playerWins++;
                }
                else{
                    pushes++;
                }
                
            }
    
            playerWinPercent.add((double)playerWins/numGames);
            dealerWinPercent.add((double)dealerWins/numGames);
            tiePercent.add((double)pushes/numGames);
    }

    


        double playerPercent = (double)playerWins/1000;
        double pushesPercent = (double)pushes/1000;
        double dealerPercent = (double)dealerWins/1000;

        //System.out.println("Player points: " + playerWins + " Ties: " + pushes + " Dealer pionts: " + dealerWins);
        //System.out.println("Player points: " + playerPercent + " Ties: " + pushesPercent + " Dealer pionts: " + dealerPercent);
        //System.out.println(playerWinPercent);
        //System.out.println(dealerWinPercent);
        //System.out.println(tiePercent);
        System.out.println(standardDeviation(playerWinPercent));
    }  
}


    public static double mean(ArrayList<Double> list){
        double total = 0.0; 
        for (Double value : list){
            total += value;
        }
        return total/list.size();
    }

    public static double standardDeviation(ArrayList<Double> list){
        double differences = 0;
        double diffSum = 0;
        double average = mean(list);
        for (Double value : list){
            differences = value - average;
            diffSum += differences * differences;

        }
        double variance = diffSum /list.size();
        double sDev = Math.sqrt(variance);
        return sDev;
    }
}

